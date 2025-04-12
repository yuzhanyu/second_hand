package com.secondhand1.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.groups.Default;

/**
 * 商品分类查询的入参封装
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class CategoryQuery {

    /**
     * 分类ID:分类ID，必填
     */
    @NotNull(groups = { QueryGroup.class }, message = "分类ID不能为空")
    @Schema(description = "分类ID:分类ID，必填")
    private Integer categoryId;
}
