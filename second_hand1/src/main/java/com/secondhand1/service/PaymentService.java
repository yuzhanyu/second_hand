package com.secondhand1.service;

import com.secondhand1.pojo.dto.OrderPaymentDTO;
import com.secondhand1.pojo.query.OrderPaymentQuery;
import java.lang.Boolean;
import java.lang.String;

/**
 * 支付接口集成
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface PaymentService {

    /**
     * request
     *
     * @param orderPaymentDTO 订单支付请求入参
     * @return
     */
    Boolean createOrderPaymentRequest(OrderPaymentDTO orderPaymentDTO);

    /**
     * status
     *
     * @param orderPaymentQuery 订单支付状态查询入参
     * @return
     */
    String queryOrderPaymentStatus(OrderPaymentQuery orderPaymentQuery);

    /**
     * cancel
     *
     * @param orderPaymentDTO 订单支付请求入参
     * @return
     */
    Boolean cancelOrderPayment(OrderPaymentDTO orderPaymentDTO);
}
