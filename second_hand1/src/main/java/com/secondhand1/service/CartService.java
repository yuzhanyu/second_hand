package com.secondhand1.service;

import com.secondhand1.pojo.domain.ShoppingCartDO;
import com.secondhand1.pojo.dto.CartDTO;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.List;

/**
 * 购物车管理
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface CartService {

    /**
     * 添加商品到购物车
     *
     * @param cartDTO 购物车操作入参
     * @return
     */
    Boolean addToCart(CartDTO cartDTO);

    /**
     * 修改购物车商品数量
     *
     * @param cartDTO 购物车操作入参
     * @return
     */
    Boolean updateCart(CartDTO cartDTO);

    /**
     * 删除购物车商品
     *
     * @param cartDTO 购物车操作入参
     * @return
     */
    Boolean deleteFromCart(CartDTO cartDTO);

    /**
     * 查看购物车
     *
     * @param userId
     * @return
     */
    List<ShoppingCartDO> viewCart(Integer userId);
}
