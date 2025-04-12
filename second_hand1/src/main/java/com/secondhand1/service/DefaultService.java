package com.secondhand1.service;

import com.secondhand1.pojo.domain.OrderDO;
import com.secondhand1.pojo.dto.OrderDTO;
import com.secondhand1.pojo.query.OrderQuery;
import com.secondhand1.pojo.vo.PageResult;
import java.lang.Boolean;

/**
 * 订单管理
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface DefaultService {

    /**
     * 接口名称:生成订单
     *
     * @param orderDTO 订单管理相关入参
     * @return
     */
    Boolean addOrder(OrderDTO orderDTO);

    /**
     * 接口名称:查看用户订单
     *
     * @param orderQuery 订单查询相关入参
     * @return
     */
    PageResult<OrderDO> listUserOrders(OrderQuery orderQuery);

    /**
     * 接口名称:查看商家订单
     *
     * @param orderQuery 订单查询相关入参
     * @return
     */
    PageResult<OrderDO> listMerchantOrders(OrderQuery orderQuery);

    /**
     * 接口名称:更新订单状态
     *
     * @param orderDTO 订单管理相关入参
     * @return
     */
    Boolean updateOrderStatus(OrderDTO orderDTO);

    /**
     * 接口名称:取消订单
     *
     * @param orderDTO 订单管理相关入参
     * @return
     */
    Boolean cancelOrder(OrderDTO orderDTO);
}
