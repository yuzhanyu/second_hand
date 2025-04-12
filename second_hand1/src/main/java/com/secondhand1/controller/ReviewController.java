package com.secondhand1.controller;

import com.secondhand1.constant.ResultCodeConstant;
import com.secondhand1.pojo.domain.ProductReviewDO;
import com.secondhand1.pojo.dto.CreateGroup;
import com.secondhand1.pojo.dto.ProductReviewDTO;
import com.secondhand1.pojo.dto.RestResult;
import com.secondhand1.pojo.query.ProductReviewQuery;
import com.secondhand1.pojo.query.QueryGroup;
import com.secondhand1.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论与评价管理模块
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Tag(name = "评论与评价管理模块")
@RequestMapping("review")
@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    /**
     * 新增评论与评分
     *
     * @param productReviewDTO 评论与评分添加的入参对象
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Operation(summary = "新增评论与评分")
    @ResponseBody
    public RestResult<Boolean> addReview(@RequestBody @Validated(CreateGroup.class) ProductReviewDTO productReviewDTO) {
        Boolean result = reviewService.addReview(productReviewDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 查看商品评论
     *
     * @param productReviewQuery 评论查询的入参对象
     * @return
     */
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    @Operation(summary = "查看商品评论")
    public RestResult<List<ProductReviewDO>> getProductReviews(@Validated(QueryGroup.class) ProductReviewQuery productReviewQuery) {
        List<ProductReviewDO> result = reviewService.getProductReviews(productReviewQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 商家回复评论
     *
     * @param productReviewDTO 评论与评分添加的入参对象
     * @return
     */
    @RequestMapping(value = "/reply", method = RequestMethod.PUT)
    @Operation(summary = "商家回复评论")
    @ResponseBody
    public RestResult<Boolean> replyReview(@RequestBody @Validated(CreateGroup.class) ProductReviewDTO productReviewDTO) {
        Boolean result = reviewService.replyReview(productReviewDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 删除评论
     *
     * @param productReviewQuery 评论查询的入参对象
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @Operation(summary = "删除评论")
    public RestResult<Boolean> deleteReview(@Validated(QueryGroup.class) ProductReviewQuery productReviewQuery) {
        Boolean result = reviewService.deleteReview(productReviewQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}
