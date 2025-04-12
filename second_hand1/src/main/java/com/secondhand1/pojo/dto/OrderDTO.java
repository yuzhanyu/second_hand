package com.secondhand1.pojo.dto;

import com.secondhand1.pojo.query.QueryGroup;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 订单管理相关入参
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class OrderDTO {

    /**
     * 用户id：必填
     */
    @NotNull(groups = { CreateGroup.class, QueryGroup.class }, message = "用户id不能为空")
    @Schema(description = "用户id：必填")
    private Integer userId;

    /**
     * 订单id：必填
     */
    @NotNull(groups = { CreateGroup.class }, message = "订单id不能为空")
    @Schema(description = "订单id：必填")
    private Integer orderId;

    /**
     * 订单状态：必填
     */
//    @NotBlank(groups = { CreateGroup.class }, message = "订单状态不能为空")
//    @Schema(description = "订单状态：必填")
    private String orderStatus;
}
