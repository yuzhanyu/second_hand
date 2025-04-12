package com.secondhand1.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 购物车查询入参
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class CartQuery {

    /**
     * 用户ID:必填
     */
    @NotNull(groups = { QueryGroup.class }, message = "用户ID不能为空")
    @Schema(description = "用户ID:必填")
    private Integer userId;
}
