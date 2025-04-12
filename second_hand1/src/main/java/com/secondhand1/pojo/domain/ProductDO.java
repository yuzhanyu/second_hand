package com.secondhand1.pojo.domain;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * 商品信息实体类
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Data
public class ProductDO {

    /**
     * 商品ID:商品ID
     */
    @Schema(description = "商品ID:商品ID")
    private Integer productId;

    /**
     * 商家ID:商家ID
     */
    @Schema(description = "商家ID:商家ID")
    private Integer merchantId;

    /**
     * 商品名称:商品名称
     */
    @Schema(description = "商品名称:商品名称")
    private String name;

    /**
     * 商品描述:商品描述
     */
    @Schema(description = "商品描述:商品描述")
    private String description;

    /**
     * 商品价格:商品价格
     */
    @Schema(description = "商品价格:商品价格")
    private java.math.BigDecimal price;

    /**
     * 库存数量:库存数量
     */
    @Schema(description = "库存数量:库存数量")
    private Integer stock;

    /**
     * 分类ID:分类ID
     */
    @Schema(description = "分类ID:分类ID")
    private Integer categoryId;

    /**
     * 商品状态:商品状态
     */
    @Schema(description = "商品状态:商品状态")
    private String status;

    /**
     * 创建人:创建人
     */
    @Schema(description = "创建人:创建人")
    private Integer createBy;

    /**
     * 创建时间:创建时间
     */
    @Schema(description = "创建时间:创建时间")
    private java.util.Date createTime;

    /**
     * 修改人:修改人
     */
    @Schema(description = "修改人:修改人")
    private Integer updateBy;

    /**
     * 修改时间:修改时间
     */
    @Schema(description = "修改时间:修改时间")
    private java.util.Date updateTime;

    /**
     * 商家信息: 商家信息
     */
    @Schema(description = "商家信息: 商家信息")
    private MerchantDO merchant;

    /**
     * 商品分类信息: 商品分类信息
     */
    @Schema(description = "商品分类信息: 商品分类信息")
    private CategoryDO category;

    /**
     * 商品评论信息: 商品评论信息
     */
    @Schema(description = "商品评论信息: 商品评论信息")
    private List<ProductReviewDO> reviews;

    /**
     * 商品图片: 商品图片
     */
    @Schema(description = "商品图片: 商品图片")
    private String image;


}
