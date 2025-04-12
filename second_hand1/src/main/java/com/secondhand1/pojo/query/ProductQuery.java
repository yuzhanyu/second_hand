package com.secondhand1.pojo.query;

import io.micrometer.common.lang.Nullable;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.groups.Default;

/**
 * 商品查询的入参封装
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class ProductQuery {

    /**
     * 商品ID:商品ID，必填
     */
//    @NotNull(groups = { QueryGroup.class }, message = "商品ID不能为空")
    @Nullable
    @Schema(description = "商品ID:商品ID，必填")
    private Integer productId;

    /**
     * 关键词:关键词，必填
     */
//    @NotBlank(groups = { QueryGroup.class }, message = "关键词不能为空")
    @Schema(description = "关键词:关键词，不必填")
    private String keyword;

    /**
     * 页码:页码，必填
     */
//    @NotNull(groups = { QueryGroup.class }, message = "页码不能为空")
//    @Positive(groups = { QueryGroup.class }, message = "页码必须为正数")
    @Schema(description = "页码:页码，必填")
    private Integer page;

    /**
     * 每页显示数量:每页显示数量，必填
     */
//    @NotNull(groups = { QueryGroup.class }, message = "每页显示数量不能为空")
//    @Positive(groups = { QueryGroup.class }, message = "每页显示数量必须为正数")
    @Schema(description = "每页显示数量:每页显示数量，必填")
    private Integer pageSize;
}
