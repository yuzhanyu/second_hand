package com.secondhand1.service;

import com.secondhand1.pojo.domain.CategoryDO;
import com.secondhand1.pojo.domain.ProductDO;
import com.secondhand1.pojo.domain.ProductReviewDO;
import com.secondhand1.pojo.dto.CategoryDTO;
import com.secondhand1.pojo.dto.ProductDTO;
import com.secondhand1.pojo.query.CategoryQuery;
import com.secondhand1.pojo.query.ProductQuery;
import com.secondhand1.pojo.vo.PageResult;
import java.lang.Boolean;
import java.util.List;

/**
 * 商品管理模块
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface ProductService {

    /**
     * 发布商品:验证商家是否有效
     *
     * @param productDTO 商品信息的入参封装
     * @return
     */
    Boolean addProduct(ProductDTO productDTO);

    /**
     * 修改商品:验证商家是否有效
     *
     * @param productDTO 商品信息的入参封装
     * @return
     */
    Boolean updateProduct(ProductDTO productDTO);

    /**
     * 查看商品:验证商品是否存在
     *
     * @param productQuery 商品查询的入参封装
     * @return  商品信息实体类
     */
    ProductDO getProductInfo(ProductQuery productQuery);

    /**
     * 删除商品:验证商家是否有效
     *
     * @param productDTO 商品信息的入参封装
     * @return
     */
    Boolean deleteProduct(ProductDTO productDTO);

    /**
     * 查看所有商品
     *
     * @return
     */
    List<ProductDO> getAllProducts();

    /**
     * 查看分类商品:验证分类是否存在
     *
     * @param categoryQuery 商品分类查询的入参封装
     * @return
     */
    List<ProductDO> getProductsByCategory(CategoryQuery categoryQuery);

    /**
     * 新增商品分类:验证商家是否有效
     *
     * @param categoryDTO 商品分类信息的入参封装
     * @return
     */
    Boolean addCategory(CategoryDTO categoryDTO);

    /**
     * 修改商品分类:验证商家是否有效
     *
     * @param categoryDTO 商品分类信息的入参封装
     * @return
     */
    Boolean updateCategory(CategoryDTO categoryDTO);

    /**
     * 删除商品分类:验证商家是否有效
     *
     * @param categoryDTO 商品分类信息的入参封装
     * @return
     */
    Boolean deleteCategory(CategoryDTO categoryDTO);

    /**
     * 浏览所有商品
     *
     * @param productQuery 商品查询的入参封装
     * @return
     */
//    PageResult<ProductDO> browseProducts(ProductQuery productQuery);

    /**
     * 搜索商品
     *
     * @param productQuery 商品查询的入参封装
     * @return
     */
    PageResult<ProductDO> searchProducts(ProductQuery productQuery);

    /**
     * 查看商品详细信息: 根据商品ID查询商品信息、商家信息、商品分类信息、商品评论信息
     *
     * @param productQuery 商品查询的入参封装
     * @return  商品信息实体类
     */
    ProductDO productInfo(ProductQuery productQuery);

    /**
     * 查看商品评论列表: 根据商品ID查询所有评论
     *
     * @param productQuery 商品查询的入参封装
     * @return
     */
    List<ProductReviewDO> productReviews(ProductQuery productQuery);

    /**
     * 查看商品分类详细信息: 根据分类ID查询分类信息
     *
     * @param categoryQuery 商品分类查询的入参封装
     * @return  商品分类信息实体类
     */
    CategoryDO productCategory(CategoryQuery categoryQuery);

    List<CategoryDO> getAllCategory();
}
