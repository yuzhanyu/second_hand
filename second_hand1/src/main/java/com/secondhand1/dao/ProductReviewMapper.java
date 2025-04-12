package com.secondhand1.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.secondhand1.pojo.domain.ProductReviewDO;

/**
 * ProductReviewMapper
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface ProductReviewMapper {

    /**
     * 根据商品ID查询所有评论
     *
     * @Param productId 商品ID
     * @Return 商品评论列表
     */
    List<ProductReviewDO> selectAllByProductId(Integer productId);

    /**
     * 根据评论ID查询评论信息
     * @Param reviewId 评论ID
     * @Return 评论信息
     */
    ProductReviewDO selectById(Integer reviewId);

    /**
     * 根据商品ID查询评论信息
     * @Param productId 商品ID
     * @Return 评论信息列表
     */
    List<ProductReviewDO> selectByProductId(Integer productId);

    /**
     * 插入评论信息
     * @Param productReviewDO 评论实体对象
     * @Return 插入结果
     */
    int insert(ProductReviewDO productReviewDO);

    /**
     * 更新商家回复信息
     * @Param productReviewDO 评论实体对象
     * @Return 更新结果
     */
    int updateReply(ProductReviewDO productReviewDO);

    /**
     * 删除评论信息
     * @Param reviewId 评论ID
     * @Return 删除结果
     */
    int deleteById(Integer reviewId);
}
