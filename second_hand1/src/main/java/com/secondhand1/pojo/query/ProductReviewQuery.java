package com.secondhand1.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 评论查询的入参对象
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class ProductReviewQuery {

    /**
     * 评论ID:评论id，必填
     */
//    @NotNull(groups = { QueryGroup.class, Default.class }, message = "评论ID不能为空")
//    @Schema(description = "评论ID:评论id，必填")
    private Integer reviewId;

    /**
     * 商品ID:商品id，必填
     */
//    @NotNull(groups = { QueryGroup.class, Default.class }, message = "商品ID不能为空")
//    @Schema(description = "商品ID:商品id，必填")
    private Integer productId;
}
