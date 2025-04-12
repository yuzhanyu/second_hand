package com.secondhand1.controller;

import com.secondhand1.constant.ResultCodeConstant;
import com.secondhand1.pojo.domain.ShoppingCartDO;
import com.secondhand1.pojo.dto.CartDTO;
import com.secondhand1.pojo.dto.CreateGroup;
import com.secondhand1.pojo.dto.DeleteGroup;
import com.secondhand1.pojo.dto.RestResult;
import com.secondhand1.pojo.dto.UpdateGroup;
import com.secondhand1.pojo.query.QueryGroup;
import com.secondhand1.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 购物车管理
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Tag(name = "购物车管理")
@RequestMapping("cart")
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 添加商品到购物车
     *
     * @param cartDTO 购物车操作入参
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Operation(summary = "添加商品到购物车")
    @ResponseBody
    public RestResult<Boolean> addToCart(@RequestBody @Validated(CreateGroup.class) CartDTO cartDTO) {
        Boolean result = cartService.addToCart(cartDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 修改购物车商品数量
     *
     * @param cartDTO 购物车操作入参
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Operation(summary = "修改购物车商品数量")
    @ResponseBody
    public RestResult<Boolean> updateCart(@RequestBody @Validated(UpdateGroup.class) CartDTO cartDTO) {
        Boolean result = cartService.updateCart(cartDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 删除购物车商品
     *
     * @param cartDTO 购物车操作入参
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @Operation(summary = "删除购物车商品")
    @ResponseBody
    public RestResult<Boolean> deleteFromCart(@RequestBody @Validated(DeleteGroup.class) CartDTO cartDTO) {
        Boolean result = cartService.deleteFromCart(cartDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 查看购物车
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @Operation(summary = "查看购物车")
    public RestResult<List<ShoppingCartDO>> viewCart(@Validated(QueryGroup.class) Integer userId) {
        List<ShoppingCartDO> result = cartService.viewCart(userId);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}
