package com.secondhand1.pojo.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 订单项实体对象
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDO {

    /**
     * 订单项ID
     */
    @Schema(description = "订单项ID")
    private Integer itemId;

    /**
     * 订单ID
     */
    @Schema(description = "订单ID")
    private Integer orderId;

    /**
     * 商品ID
     */
    @Schema(description = "商品ID")
    private Integer productId;

    /**
     * 商品数量
     */
    @Schema(description = "商品数量")
    private Integer quantity;

    /**
     * 商品单价
     */
    @Schema(description = "商品单价")
    private Double price;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    private Date updateTime;
}
