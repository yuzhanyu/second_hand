package com.secondhand1.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 购物车操作入参
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class CartDTO {

    /**
     * 用户ID:必填
     */
    @NotNull(groups = { CreateGroup.class, UpdateGroup.class, DeleteGroup.class }, message = "用户ID不能为空")
    @Schema(description = "用户ID:必填")
    private Integer userId;

    /**
     * 商品ID:必填
     */
    @NotNull(groups = { CreateGroup.class, UpdateGroup.class, DeleteGroup.class }, message = "商品ID不能为空")
    @Schema(description = "商品ID:必填")
    private Integer productId;

    /**
     * 商品数量:必填
     */
    @NotNull(groups = { CreateGroup.class, UpdateGroup.class }, message = "商品数量不能为空")
    @Schema(description = "商品数量:必填")
    private Integer quantity;
}
