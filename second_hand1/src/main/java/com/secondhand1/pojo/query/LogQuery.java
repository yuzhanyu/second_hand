package com.secondhand1.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 日志查询参数
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class LogQuery {

    /**
     * 用户ID
     */
//    @NotNull(groups = { QueryGroup.class }, message = "用户ID不能为空")
    @Schema(description = "用户ID")
    private Integer userId;

    /**
     * 商家ID
     */
//    @NotNull(groups = { QueryGroup.class }, message = "商家ID不能为空")
    @Schema(description = "商家ID")
    private Integer merchantId;

    /**
     * 当前页码
     */
//    @NotNull(groups = { QueryGroup.class }, message = "当前页码不能为空")
    @Schema(description = "当前页码")
    private Integer pageIndex;

    /**
     * 每页记录数
     */
//    @NotNull(groups = { QueryGroup.class }, message = "每页记录数不能为空")
    @Schema(description = "每页记录数")
    private Integer pageSize;
}
