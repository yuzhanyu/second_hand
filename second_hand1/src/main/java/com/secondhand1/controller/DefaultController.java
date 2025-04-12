package com.secondhand1.controller;

import com.secondhand1.constant.ResultCodeConstant;
import com.secondhand1.pojo.domain.OrderDO;
import com.secondhand1.pojo.dto.CreateGroup;
import com.secondhand1.pojo.dto.OrderDTO;
import com.secondhand1.pojo.dto.RestResult;
import com.secondhand1.pojo.query.OrderQuery;
import com.secondhand1.pojo.query.QueryGroup;
import com.secondhand1.pojo.vo.PageResult;
import com.secondhand1.service.DefaultService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单管理
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Tag(name = "订单管理")
@RequestMapping("default")
@RestController
public class DefaultController {

    @Autowired
    private DefaultService defaultService;

    /**
     * 接口名称:生成订单
     *
     * @param orderDTO 订单管理相关入参
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Operation(summary = "接口名称:生成订单")
    @ResponseBody
    public RestResult<Boolean> addOrder(@RequestBody @Validated(CreateGroup.class) OrderDTO orderDTO) {
        Boolean result = defaultService.addOrder(orderDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 接口名称:查看用户订单
     *
     * @param orderQuery 订单查询相关入参
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @Operation(summary = "接口名称:查看用户订单")
    public RestResult<PageResult<OrderDO>> listUserOrders(@Validated(QueryGroup.class) OrderQuery orderQuery) {
        PageResult<OrderDO> result = defaultService.listUserOrders(orderQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 接口名称:查看商家订单
     *
     * @param orderQuery 订单查询相关入参
     * @return
     */
    @RequestMapping(value = "/merchant-list", method = RequestMethod.GET)
    @Operation(summary = "接口名称:查看商家订单")
    public RestResult<PageResult<OrderDO>> listMerchantOrders(@Validated(QueryGroup.class) OrderQuery orderQuery) {
        PageResult<OrderDO> result = defaultService.listMerchantOrders(orderQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 接口名称:更新订单状态
     *
     * @param orderDTO 订单管理相关入参
     * @return
     */
    @RequestMapping(value = "/status", method = RequestMethod.PUT)
    @Operation(summary = "接口名称:更新订单状态")
    public RestResult<Boolean> updateOrderStatus(@Validated(CreateGroup.class) OrderDTO orderDTO) {
        Boolean result = defaultService.updateOrderStatus(orderDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 接口名称:取消订单
     *
     * @param orderDTO 订单管理相关入参
     * @return
     */
    @RequestMapping(value = "/cancel", method = RequestMethod.PUT)
    @Operation(summary = "接口名称:取消订单")
    public RestResult<Boolean> cancelOrder(@Validated(CreateGroup.class) OrderDTO orderDTO) {
        Boolean result = defaultService.cancelOrder(orderDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}
