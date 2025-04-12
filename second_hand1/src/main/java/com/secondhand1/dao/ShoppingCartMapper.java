package com.secondhand1.dao;

import java.util.List;
import com.secondhand1.pojo.domain.ShoppingCartDO;
import org.apache.ibatis.annotations.Param;

/**
 * ShoppingCartMapper
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface ShoppingCartMapper {

    /**
     * 根据用户ID和商品ID查询购物车记录
     * @Param userId
     * @Param productId
     * @Return ShoppingCartDO
     */
    ShoppingCartDO selectByUserIdAndProductId(Integer userId, Integer productId);

    /**
     * 根据用户ID查询购物车所有记录
     * @Param userId
     * @Return List<ShoppingCartDO>
     */
    List<ShoppingCartDO> selectByUserId(Integer userId);

    /**
     * 插入购物车记录
     * @Param shoppingCartDO
     * @Return int
     */
    int insert(ShoppingCartDO shoppingCartDO);

    /**
     * 根据购物车ID更新购物车记录
     * @Param shoppingCartDO
     * @Return int
     */
    int updateById(ShoppingCartDO shoppingCartDO);

    /**
     * 根据购物车ID删除购物车记录
     * @Param cartId
     * @Return int
     */
    int deleteById(Integer cartId);

    /**
     * 根据用户ID删除购物车信息
     *
     * @Param userId 用户ID
     * @Return 影响行数
     */
    int deleteByUserId(@Param("userId") Integer userId);
}
