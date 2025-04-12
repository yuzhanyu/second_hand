package com.secondhand1.dao;

import java.util.List;
import com.secondhand1.pojo.domain.OrderDO;
import com.secondhand1.pojo.domain.OrderItemDO;
import org.apache.ibatis.annotations.Param;
import com.secondhand1.pojo.domain.LogDO;

/**
 * OrderMapper
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface OrderMapper {

    /**
     * 根据用户ID查询订单列表
     *
     * @Param userId 用户ID
     * @Param pageIndex 页码
     * @Param pageSize 每页数量
     * @Return 订单列表
     */
    List<OrderDO> selectByUserId(@Param("userId") Integer userId, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 根据用户ID查询订单数量
     *
     * @Param userId 用户ID
     * @Return 订单数量
     */
    long countByUserId(@Param("userId") Integer userId);

    /**
     * 根据商家ID查询订单列表
     *
     * @Param merchantId 商家ID
     * @Param pageIndex 页码
     * @Param pageSize 每页数量
     * @Return 订单列表
     */
    List<OrderDO> selectByMerchantId(@Param("merchantId") Integer merchantId, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 根据商家ID查询订单数量
     *
     * @Param merchantId 商家ID
     * @Return 订单数量
     */
    long countByMerchantId(@Param("merchantId") Integer merchantId);

    /**
     * 根据订单ID查询订单信息
     *
     * @Param orderId 订单ID
     * @Return 订单信息
     */
    OrderDO selectById(@Param("orderId") Integer orderId);

    /**
     * 插入订单信息
     *
     * @Param orderDO 订单信息
     * @Return 影响行数
     */
    int insert(OrderDO orderDO);

    /**
     * 根据订单ID更新订单信息
     *
     * @Param orderDO 订单信息
     * @Return 影响行数
     */
    int updateById(OrderDO orderDO);

    /**
     * 插入日志信息
     *
     * @Param logDO 日志实体类
     * @Return 插入结果
     */
    int insertLog(LogDO logDO);

    /**
     * 根据商家ID查询订单信息
     *
     * @Param merchantId 商家ID
     * @Return List<OrderDO> 订单信息列表
     */
    List<OrderDO> selectByMerchantId(Integer merchantId);
    List<OrderItemDO> selectOrderItemsByMerchantId(Long merchantId);
}
