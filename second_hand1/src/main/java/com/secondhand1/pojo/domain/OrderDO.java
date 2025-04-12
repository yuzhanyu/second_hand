package com.secondhand1.pojo.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

/**
 * 订单实体对象
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDO {

    /**
     * 订单ID
     */
    @Schema(description = "订单ID")
    private Integer orderId;

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Integer userId;

    /**
     * 订单状态
     */
    @Schema(description = "订单状态")
    private String orderStatus;

    /**
     * 订单总金额
     */
    @Schema(description = "订单总金额")
    private Double totalAmount;

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
