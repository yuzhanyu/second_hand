package com.secondhand1.service.impl;

import com.secondhand1.dao.ProductMapper;
import com.secondhand1.dao.ShoppingCartMapper;
import com.secondhand1.dao.UserMapper;
import com.secondhand1.pojo.domain.ShoppingCartDO;
import com.secondhand1.pojo.dto.CartDTO;
import com.secondhand1.service.CartService;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Override;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.secondhand1.exception.BusinessException;
import com.secondhand1.pojo.domain.UserDO;
import java.util.Map;
import com.secondhand1.constant.ResultCodeConstant;
import com.secondhand1.pojo.domain.ProductDO;
import java.util.Date;

/**
 * 购物车管理的实现
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Service
public class CartServiceImpl implements CartService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CartServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Boolean addToCart(CartDTO cartDTO) {
        try {
            log.info("addToCart request received: {}", cartDTO);
            // 检查用户是否存在
            UserDO userDO = userMapper.selectById(cartDTO.getUserId());
            if (userDO == null) {
                log.warn("用户不存在，可能是用户ID无效或未登录");
                throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
            }
            // 检查商品是否存在
            ProductDO productDO = productMapper.selectById(cartDTO.getProductId());
            if (productDO == null) {
                log.warn("商品不存在，可能是商品ID无效");
                throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
            }
            // 检查商品库存数量是否足够
            if (productDO.getStock() < cartDTO.getQuantity()) {
                log.warn("商品库存不足");
                throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
            }
            // 检查购物车中是否已有该商品
            ShoppingCartDO cartDO = shoppingCartMapper.selectByUserIdAndProductId(cartDTO.getUserId(), cartDTO.getProductId());
            if (cartDO != null) {
                // 更新数量
                cartDO.setQuantity(cartDO.getQuantity() + cartDTO.getQuantity());
                cartDO.setUpdateTime(new Date());
                shoppingCartMapper.updateById(cartDO);
                log.info("Updated cart item: {}", cartDO);
            } else {
                // 插入新记录
                ShoppingCartDO newCartDO = new ShoppingCartDO();
                newCartDO.setUserId(cartDTO.getUserId());
                newCartDO.setProductId(cartDTO.getProductId());
                newCartDO.setQuantity(cartDTO.getQuantity());
                newCartDO.setCreateTime(new Date());
                newCartDO.setUpdateTime(new Date());
                shoppingCartMapper.insert(newCartDO);
                log.info("Inserted new cart item: {}", newCartDO);
            }
            return true;
        } catch (Exception e) {
            log.error("addToCart failed", e);
            return false;
        }
    }

    @Override
    public Boolean updateCart(CartDTO cartDTO) {
        // 检查用户是否存在
        UserDO userDO = userMapper.selectById(cartDTO.getUserId());
        if (userDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 检查商品是否存在
        ProductDO productDO = productMapper.selectById(cartDTO.getProductId());
        if (productDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 检查商品库存数量是否足够
        if (productDO.getStock() < cartDTO.getQuantity()) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 检查购物车中是否有该商品
        ShoppingCartDO cartDO = shoppingCartMapper.selectByUserIdAndProductId(cartDTO.getUserId(), cartDTO.getProductId());
        if (cartDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        } else {
            // 更新数量
            cartDO.setQuantity(cartDTO.getQuantity());
            cartDO.setUpdateTime(new Date());
            shoppingCartMapper.updateById(cartDO);
            return true;
        }
    }

    @Override
    public Boolean deleteFromCart(CartDTO cartDTO) {
        // 检查用户是否存在
        UserDO userDO = userMapper.selectById(cartDTO.getUserId());
        if (userDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 检查商品是否存在
        ProductDO productDO = productMapper.selectById(cartDTO.getProductId());
        if (productDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 检查购物车中是否有该商品
        ShoppingCartDO cartDO = shoppingCartMapper.selectByUserIdAndProductId(cartDTO.getUserId(), cartDTO.getProductId());
        if (cartDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        } else {
            // 删除购物车商品
            shoppingCartMapper.deleteById(cartDO.getCartId());
            return true;
        }
    }

    @Override
    public List<ShoppingCartDO> viewCart(Integer userId) {
        // 检查用户是否存在
        UserDO userDO = userMapper.selectById(userId);
        if (userDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 获取用户购物车中的所有商品信息
        List<ShoppingCartDO> cartDOList = shoppingCartMapper.selectByUserId(userId);
        return cartDOList;
    }
}
