package com.secondhand1.service.impl;

import com.secondhand1.dao.ProductMapper;
import com.secondhand1.dao.ProductReviewMapper;
import com.secondhand1.dao.UserMapper;
import com.secondhand1.pojo.domain.ProductReviewDO;
import com.secondhand1.pojo.dto.ProductReviewDTO;
import com.secondhand1.pojo.query.ProductReviewQuery;
import com.secondhand1.service.ReviewService;
import java.lang.Boolean;
import java.lang.Override;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.secondhand1.exception.BusinessException;
import java.util.Map;
import com.secondhand1.constant.ResultCodeConstant;
import java.util.Date;

/**
 * 评论与评价管理模块的实现
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ProductReviewMapper productReviewMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Boolean addReview(ProductReviewDTO productReviewDTO) {
        // 验证商品是否存在
        if (productMapper.selectById(productReviewDTO.getProductId()) == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 验证用户是否存在
        if (userMapper.selectById(productReviewDTO.getUserId()) == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 将评论与评分信息保存到数据库
        ProductReviewDO productReviewDO = new ProductReviewDO();
        productReviewDO.setProductId(productReviewDTO.getProductId());
        productReviewDO.setUserId(productReviewDTO.getUserId());
        productReviewDO.setRating(productReviewDTO.getRating());
        productReviewDO.setComment(productReviewDTO.getComment());
        productReviewDO.setCreateTime(new Date());
        productReviewDO.setMerchantId(productMapper.selectById(productReviewDTO.getProductId()).getMerchantId());
        int result = productReviewMapper.insert(productReviewDO);
        return result > 0;
    }

    @Override
    public List<ProductReviewDO> getProductReviews(ProductReviewQuery productReviewQuery) {
        // 验证商品是否存在
        if (productMapper.selectById(productReviewQuery.getProductId()) == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 获取商品的所有评论与评分信息
        List<ProductReviewDO> productReviews = productReviewMapper.selectByProductId(productReviewQuery.getProductId());
        return productReviews;
    }

    @Override
    public Boolean replyReview(ProductReviewDTO productReviewDTO) {
        // 验证评论是否存在
        if (productReviewMapper.selectById(productReviewDTO.getReviewId()) == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 保存商家回复信息到数据库
        ProductReviewDO productReviewDO = new ProductReviewDO();
        productReviewDO.setReviewId(productReviewDTO.getReviewId());
        productReviewDO.setReplyComment(productReviewDTO.getReplyComment());
        productReviewDO.setUpdateTime(new Date());
        int result = productReviewMapper.updateReply(productReviewDO);
        return result > 0;
    }

    @Override
    public Boolean deleteReview(ProductReviewQuery productReviewQuery) {
        // 验证评论是否存在
        if (productReviewMapper.selectById(productReviewQuery.getReviewId()) == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 删除评论信息
        int result = productReviewMapper.deleteById(productReviewQuery.getReviewId());
        return result > 0;
    }
}
