package com.secondhand1.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 订单支付状态查询入参
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class OrderPaymentQuery {

    /**
     * 订单ID:订单ID，必填
     */
    @NotNull(groups = { QueryGroup.class }, message = "订单ID不能为空")
    @Schema(description = "订单ID:订单ID，必填")
    private Integer orderId;
}
