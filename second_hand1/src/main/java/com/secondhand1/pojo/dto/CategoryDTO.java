package com.secondhand1.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 商品分类信息的入参封装
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class CategoryDTO {

    /**
     * 分类ID:分类ID，必填，用于Update和Delete操作
     */
    @NotNull(groups = { UpdateGroup.class, DeleteGroup.class }, message = "分类ID不能为空")
    @Schema(description = "分类ID:分类ID，必填，用于Update和Delete操作")
    private Integer categoryId;

    /**
     * 商家ID:商家ID，必填，用于Create, Update和Delete操作
     */
    @NotNull(groups = { CreateGroup.class, UpdateGroup.class, DeleteGroup.class }, message = "商家ID不能为空")
    @Schema(description = "商家ID:商家ID，必填，用于Create, Update和Delete操作")
    private Integer merchantId;

    /**
     * 分类名称:分类名称，必填，用于Create和Update操作
     */
    @NotBlank(groups = { CreateGroup.class, UpdateGroup.class }, message = "分类名称不能为空")
    @Schema(description = "分类名称:分类名称，必填，用于Create和Update操作")
    private String name;

    /**
     * 分类描述:分类描述，用于Create和Update操作
     */
    @Schema(description = "分类描述:分类描述，用于Create和Update操作")
    private String description;
}
