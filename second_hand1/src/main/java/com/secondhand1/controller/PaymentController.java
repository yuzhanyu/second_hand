package com.secondhand1.controller;

import com.secondhand1.constant.ResultCodeConstant;
import com.secondhand1.pojo.dto.CreateGroup;
import com.secondhand1.pojo.dto.OrderPaymentDTO;
import com.secondhand1.pojo.dto.RestResult;
import com.secondhand1.pojo.query.OrderPaymentQuery;
import com.secondhand1.pojo.query.QueryGroup;
import com.secondhand1.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付接口集成
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Tag(name = "支付接口集成")
@RequestMapping("payment")
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * request
     *
     * @param orderPaymentDTO 订单支付请求入参
     * @return
     */
    @RequestMapping(value = "/request", method = RequestMethod.POST)
    @Operation(summary = "支付请求")
    @ResponseBody
    public RestResult<Boolean> createOrderPaymentRequest(@RequestBody @Validated(CreateGroup.class) OrderPaymentDTO orderPaymentDTO) {
        Boolean result = paymentService.createOrderPaymentRequest(orderPaymentDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * status
     *
     * @param orderPaymentQuery 订单支付状态查询入参
     * @return
     */
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    @Operation(summary = "订单状态")
    public RestResult<String> queryOrderPaymentStatus(@Validated(QueryGroup.class) OrderPaymentQuery orderPaymentQuery) {
        String result = paymentService.queryOrderPaymentStatus(orderPaymentQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * cancel
     *
     * @param orderPaymentDTO 订单支付请求入参
     * @return
     */
    @RequestMapping(value = "/cancel", method = RequestMethod.DELETE)
    @Operation(summary = "取消订单")
    @ResponseBody
    public RestResult<Boolean> cancelOrderPayment(@RequestBody @Validated(CreateGroup.class) OrderPaymentDTO orderPaymentDTO) {
        Boolean result = paymentService.cancelOrderPayment(orderPaymentDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}
