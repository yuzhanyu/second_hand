package com.secondhand1.pojo.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 商品评论数据对象
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductReviewDO {

    /**
     * 评论ID: 评论ID
     */
    @Schema(description = "评论ID: 评论ID")
    private Integer reviewId;

    /**
     * 商品ID: 商品ID
     */
    @Schema(description = "商品ID: 商品ID")
    private Integer productId;

    /**
     * 用户ID: 用户ID
     */
    @Schema(description = "用户ID: 用户ID")
    private Integer userId;

    /**
     * 评分: 评分
     */
    @Schema(description = "评分: 评分")
    private Integer rating;

    /**
     * 评论内容: 评论内容
     */
    @Schema(description = "评论内容: 评论内容")
    private String comment;

    /**
     * 创建时间: 创建时间
     */
    @Schema(description = "创建时间: 创建时间")
    private Date createTime;

    /**
     * 修改时间: 修改时间
     */
    @Schema(description = "修改时间: 修改时间")
    private Date updateTime;

    /**
     * 商家ID:商家ID
     */
    @Schema(description = "商家ID:商家ID")
    private Integer merchantId;

    /**
     * 回复内容:回复内容
     */
    @Schema(description = "回复内容:回复内容")
    private String replyComment;
}
