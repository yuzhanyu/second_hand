package com.secondhand1.service.impl;

import com.secondhand1.dao.OrderItemMapper;
import com.secondhand1.dao.OrderMapper;
import com.secondhand1.dao.ProductMapper;
import com.secondhand1.dao.ShoppingCartMapper;
import com.secondhand1.pojo.domain.OrderDO;
import com.secondhand1.pojo.dto.OrderDTO;
import com.secondhand1.pojo.query.OrderQuery;
import com.secondhand1.pojo.vo.PageResult;
import com.secondhand1.service.DefaultService;
import java.lang.Boolean;
import java.lang.Override;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import com.secondhand1.exception.BusinessException;
import java.util.List;
import com.secondhand1.pojo.domain.OrderItemDO;
import java.util.Map;
import com.secondhand1.constant.ResultCodeConstant;
import com.secondhand1.pojo.domain.ProductDO;
import javax.validation.groups.Default;
import java.util.Date;
import com.secondhand1.pojo.domain.ShoppingCartDO;

/**
 * 订单管理的实现
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Service
public class DefaultServiceImpl implements DefaultService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional
    public Boolean addOrder(OrderDTO orderDTO) {
        // 处理逻辑:检查用户的购物车是否为空
        List<ShoppingCartDO> shoppingCartDOList = shoppingCartMapper.selectByUserId(orderDTO.getUserId());
        if (shoppingCartDOList == null || shoppingCartDOList.isEmpty()) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 处理逻辑:计算订单总金额
        double totalAmount = 0.0;
        List<OrderItemDO> orderItemList = new ArrayList<>();
        for (ShoppingCartDO shoppingCartDO : shoppingCartDOList) {
            ProductDO productDO = productMapper.selectById(shoppingCartDO.getProductId());
            if (productDO == null)
                continue;
            double itemAmount = productDO.getPrice().multiply(BigDecimal.valueOf(shoppingCartDO.getQuantity())).doubleValue();
            totalAmount += itemAmount;
            OrderItemDO orderItemDO = new OrderItemDO();
            // 订单ID将在创建订单后回填
            orderItemDO.setOrderId(shoppingCartDO.getCartId());
            orderItemDO.setProductId(shoppingCartDO.getProductId());
            orderItemDO.setQuantity(shoppingCartDO.getQuantity());
            orderItemDO.setPrice(productDO.getPrice().doubleValue());
            orderItemDO.setCreateTime(new Date());
            orderItemDO.setUpdateTime(new Date());
            orderItemList.add(orderItemDO);
        }

        // 处理逻辑:创建订单记录
        OrderDO orderDO = new OrderDO();
        orderDO.setUserId(orderDTO.getUserId());
        orderDO.setOrderStatus("pending");
        orderDO.setTotalAmount(totalAmount);
        orderDO.setCreateTime(new Date());
        orderDO.setUpdateTime(new Date());
        orderMapper.insert(orderDO);
        int orderId = orderDO.getOrderId();
        // 处理逻辑:创建订单项记录
        for (OrderItemDO orderItemDO : orderItemList) {
            orderItemDO.setOrderId(orderId);
            orderItemMapper.insert(orderItemDO);
        }
        // 处理逻辑:清空用户的购物车
        shoppingCartMapper.deleteByUserId(orderDTO.getUserId());
        return true;
    }

    @Override
    public PageResult<OrderDO> listUserOrders(OrderQuery orderQuery) {
        int offset = (orderQuery.getPageIndex() - 1) * orderQuery.getPageSize();
    // 分页查询用户的订单列表
    List<OrderDO> orderDOList = orderMapper.selectByUserId(orderQuery.getUserId(), offset, orderQuery.getPageSize());
    long totalRecords = orderMapper.countByUserId(orderQuery.getUserId());
    long totalPages = totalRecords / orderQuery.getPageSize() + (totalRecords % orderQuery.getPageSize() > 0L ? 1L : 0L);
    PageResult<OrderDO> pageResult = new PageResult<>(totalRecords, totalPages, orderQuery.getPageIndex(), orderQuery.getPageSize(), orderDOList);
    return pageResult;
}


    @Override
public PageResult<OrderDO> listMerchantOrders(OrderQuery orderQuery) {
    // 分页查询商家的订单列表
    List<OrderDO> orderDOList = orderMapper.selectByMerchantId(orderQuery.getMerchantId(), orderQuery.getPageIndex(), orderQuery.getPageSize());
    long totalRecords = orderMapper.countByMerchantId(orderQuery.getMerchantId());
    long totalPages = totalRecords / orderQuery.getPageSize() + (totalRecords % orderQuery.getPageSize() > 0L ? 1L : 0L);
    PageResult<OrderDO> pageResult = new PageResult<>(totalRecords, totalPages, orderQuery.getPageIndex(), orderQuery.getPageSize(), orderDOList);
    return pageResult;
}


    @Override
    public Boolean updateOrderStatus(OrderDTO orderDTO) {
        // 处理逻辑:检查订单是否存在
        OrderDO orderDO = orderMapper.selectById(orderDTO.getOrderId());
        if (orderDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 处理逻辑:更新订单的状态
        orderDO.setOrderStatus(orderDTO.getOrderStatus());
        orderDO.setUpdateTime(new Date());
        orderMapper.updateById(orderDO);
        return true;
    }

    @Override
    public Boolean cancelOrder(OrderDTO orderDTO) {
        // 处理逻辑:检查订单是否存在
        OrderDO orderDO = orderMapper.selectById(orderDTO.getOrderId());
        if (orderDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 处理逻辑:更新订单状态为已取消
        orderDO.setOrderStatus("cancelled");
        orderDO.setUpdateTime(new Date());
        orderMapper.updateById(orderDO);
        return true;
    }
}
