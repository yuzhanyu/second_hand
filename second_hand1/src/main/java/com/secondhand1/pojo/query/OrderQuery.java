package com.secondhand1.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 订单查询相关入参
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class OrderQuery {

    /**
     * 用户id：必填
     */
//    @NotNull(groups = { QueryGroup.class }, message = "用户id不能为空")
//    @Schema(description = "用户id：必填")
    private Integer userId;

    /**
     * 商家id：必填
     */
    @NotNull(groups = { QueryGroup.class }, message = "商家id不能为空")
    @Schema(description = "商家id：必填")
    private Integer merchantId;

    /**
     * 页码：必填
     */
    @NotNull(groups = { QueryGroup.class }, message = "页码不能为空")
    @Schema(description = "页码：必填")
    private Integer pageIndex;

    /**
     * 每页数量：必填
     */
    @NotNull(groups = { QueryGroup.class }, message = "每页数量不能为空")
    @Schema(description = "每页数量：必填")
    private Integer pageSize;
}
