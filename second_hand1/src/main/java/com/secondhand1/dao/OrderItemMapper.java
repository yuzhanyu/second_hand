package com.secondhand1.dao;

import com.secondhand1.pojo.domain.OrderItemDO;
import org.apache.ibatis.annotations.Param;

/**
 * OrderItemMapper
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface OrderItemMapper {

    /**
     * 插入订单项信息
     *
     * @Param orderItemDO 订单项信息
     * @Return 影响行数
     */
    int insert(OrderItemDO orderItemDO);
}
