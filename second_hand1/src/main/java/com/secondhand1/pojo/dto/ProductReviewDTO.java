package com.secondhand1.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 评论与评分添加的入参对象
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class ProductReviewDTO {

    /**
     * 商品ID:商品id，必填
     */
    @NotNull(groups = { CreateGroup.class, Default.class }, message = "商品ID不能为空")
    @Schema(description = "商品ID:商品id，必填")
    private Integer productId;

    /**
     * 用户ID:用户id，必填
     */
    @NotNull(groups = { CreateGroup.class, Default.class }, message = "用户ID不能为空")
    @Schema(description = "用户ID:用户id，必填")
    private Integer userId;

    /**
     * 评论ID:评论id，必填
     */
//    @NotNull(groups = { CreateGroup.class, Default.class }, message = "评论ID不能为空")
//    @Schema(description = "评论ID:评论id，必填")
    private Integer reviewId;

    /**
     * 评分:评分，必填
     */
//    @NotNull(groups = { CreateGroup.class, Default.class }, message = "评分不能为空")
//    @Schema(description = "评分:评分，必填")
    private Integer rating;

    /**
     * 评论内容:评论内容，必填
     */
//    @NotBlank(groups = { CreateGroup.class, Default.class }, message = "评论内容不能为空")
//    @Schema(description = "评论内容:评论内容，必填")
    private String comment;

    /**
     * 回复内容:回复内容，必填
     */
//    @NotBlank(groups = { CreateGroup.class, Default.class }, message = "回复内容不能为空")
//    @Schema(description = "回复内容:回复内容，必填")
    private String replyComment;


}
