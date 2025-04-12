package com.secondhand1.service;

import com.secondhand1.pojo.domain.ProductReviewDO;
import com.secondhand1.pojo.dto.ProductReviewDTO;
import com.secondhand1.pojo.query.ProductReviewQuery;
import java.lang.Boolean;
import java.util.List;

/**
 * 评论与评价管理模块
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface ReviewService {

    /**
     * 新增评论与评分
     *
     * @param productReviewDTO 评论与评分添加的入参对象
     * @return
     */
    Boolean addReview(ProductReviewDTO productReviewDTO);

    /**
     * 查看商品评论
     *
     * @param productReviewQuery 评论查询的入参对象
     * @return
     */
    List<ProductReviewDO> getProductReviews(ProductReviewQuery productReviewQuery);

    /**
     * 商家回复评论
     *
     * @param productReviewDTO 评论与评分添加的入参对象
     * @return
     */
    Boolean replyReview(ProductReviewDTO productReviewDTO);

    /**
     * 删除评论
     *
     * @param productReviewQuery 评论查询的入参对象
     * @return
     */
    Boolean deleteReview(ProductReviewQuery productReviewQuery);
}
