package com.secondhand1.pojo.domain;

import lombok.Data;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 购物车实体
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class ShoppingCartDO {

    /**
     * 购物车ID
     */
    @Schema(description = "购物车ID")
    private Integer cartId;

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Integer userId;

    /**
     * 商品ID
     */
    @Schema(description = "商品ID")
    private Integer productId;

    /**
     * 商品数量
     */
    @Schema(description = "商品数量")
    private Integer quantity;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private java.util.Date createTime;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    private java.util.Date updateTime;
}
