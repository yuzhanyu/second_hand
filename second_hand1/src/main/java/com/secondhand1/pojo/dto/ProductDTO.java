package com.secondhand1.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 商品信息的入参封装
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class ProductDTO {

    /**
     * 商品ID:商品ID，必填，用于Update和Delete操作
     */
    @NotNull(groups = { UpdateGroup.class, DeleteGroup.class }, message = "商品ID不能为空")
    @Schema(description = "商品ID:商品ID，必填，用于Update和Delete操作")
    private Integer productId;

    /**
     * 商家ID:商家ID，必填，用于Create, Update和Delete操作
     */
    @NotNull(groups = { CreateGroup.class, UpdateGroup.class, DeleteGroup.class }, message = "商家ID不能为空")
    @Schema(description = "商家ID:商家ID，必填，用于Create, Update和Delete操作")
    private Integer merchantId;

    /**
     * 商品名称:商品名称，必填，用于Create和Update操作
     */
    @NotBlank(groups = { CreateGroup.class, UpdateGroup.class }, message = "商品名称不能为空")
    @Schema(description = "商品名称:商品名称，必填，用于Create和Update操作")
    private String name;

    /**
     * 商品描述:商品描述，用于Create和Update操作
     */
    @Schema(description = "商品描述:商品描述，用于Create和Update操作")
    private String description;

    /**
     * 商品价格:商品价格，必填，用于Create和Update操作
     */
    @NotNull(groups = { CreateGroup.class, UpdateGroup.class }, message = "商品价格不能为空")
    @Positive(message = "商品价格必须是正数")
    @Schema(description = "商品价格:商品价格，必填，用于Create和Update操作")
    private java.math.BigDecimal price;

    /**
     * 库存数量:库存数量，必填，用于Create和Update操作
     */
    @NotNull(groups = { CreateGroup.class, UpdateGroup.class }, message = "库存数量不能为空")
    @PositiveOrZero(message = "库存数量必须是非负数")
    @Schema(description = "库存数量:库存数量，必填，用于Create和Update操作")
    private Integer stock;

    /**
     * 分类ID:分类ID，用于Create和Update操作
     */
    @Schema(description = "分类ID:分类ID，用于Create和Update操作")
    private Integer categoryId;

    /**
     * 商品状态:商品状态，用于Update操作
     */
    @Schema(description = "商品状态:商品状态，用于Update操作")
    private String status;
    /**
     * 商品图片:商品图片，用于Create和Update操作
     */
    @Schema(description = "商品图片:商品图片，用于Create和Update操作")
    private String image;

}
