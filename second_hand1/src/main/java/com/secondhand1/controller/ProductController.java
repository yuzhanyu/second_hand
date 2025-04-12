package com.secondhand1.controller;

import com.secondhand1.constant.ResultCodeConstant;
import com.secondhand1.pojo.domain.CategoryDO;
import com.secondhand1.pojo.domain.ProductDO;
import com.secondhand1.pojo.domain.ProductReviewDO;
import com.secondhand1.pojo.dto.CategoryDTO;
import com.secondhand1.pojo.dto.CreateGroup;
import com.secondhand1.pojo.dto.DeleteGroup;
import com.secondhand1.pojo.dto.ProductDTO;
import com.secondhand1.pojo.dto.RestResult;
import com.secondhand1.pojo.dto.UpdateGroup;
import com.secondhand1.pojo.query.CategoryQuery;
import com.secondhand1.pojo.query.ProductQuery;
import com.secondhand1.pojo.query.QueryGroup;
import com.secondhand1.pojo.vo.PageResult;
import com.secondhand1.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品管理模块
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Tag(name = "商品管理模块")
@RequestMapping("product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 发布商品:验证商家是否有效
     *
     * @param productDTO 商品信息的入参封装
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Operation(summary = "发布商品:验证商家是否有效")
    @ResponseBody
    public RestResult<Boolean> addProduct(@RequestBody @Validated(CreateGroup.class) ProductDTO productDTO) {
        Boolean result = productService.addProduct(productDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 修改商品:验证商家是否有效
     *
     * @param productDTO 商品信息的入参封装
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Operation(summary = "修改商品:验证商家是否有效")
    @ResponseBody
    public RestResult<Boolean> updateProduct(@RequestBody @Validated(UpdateGroup.class) ProductDTO productDTO) {
        Boolean result = productService.updateProduct(productDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 查看商品:验证商品是否存在
     *
     * @param productQuery 商品查询的入参封装
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @Operation(summary = "查看商品:验证商品是否存在")
    public RestResult<ProductDO> getProductInfo(@Validated(QueryGroup.class) ProductQuery productQuery) {
        ProductDO result = productService.getProductInfo(productQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 删除商品:验证商家是否有效
     *
     * @param productDTO 商品信息的入参封装
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @Operation(summary = "删除商品:验证商家是否有效")
    @ResponseBody
    public RestResult<Boolean> deleteProduct(@RequestBody @Validated(DeleteGroup.class) ProductDTO productDTO) {
        Boolean result = productService.deleteProduct(productDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
    /**
     * 查看所有分类
     */
    @RequestMapping(value = "/category/all", method = RequestMethod.GET)
    @Operation(summary = "查看所有分类")
    public RestResult<List<CategoryDO>> getAllCategory() {
        List<CategoryDO> result = productService.getAllCategory();
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }


    /**
     * 查看所有商品
     *
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @Operation(summary = "查看所有商品")
    public RestResult<List<ProductDO>> getAllProducts() {
        List<ProductDO> result = productService.getAllProducts();
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 查看分类商品:验证分类是否存在
     *
     * @param categoryQuery 商品分类查询的入参封装
     * @return
     */
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    @Operation(summary = "查看分类商品:验证分类是否存在")
    public RestResult<List<ProductDO>> getProductsByCategory(@Validated(QueryGroup.class) CategoryQuery categoryQuery) {
        List<ProductDO> result = productService.getProductsByCategory(categoryQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 新增商品分类:验证商家是否有效
     *
     * @param categoryDTO 商品分类信息的入参封装
     * @return
     */
    @RequestMapping(value = "/category/add", method = RequestMethod.POST)
    @Operation(summary = "新增商品分类:验证商家是否有效")
    @ResponseBody
    public RestResult<Boolean> addCategory(@RequestBody @Validated(CreateGroup.class) CategoryDTO categoryDTO) {
        Boolean result = productService.addCategory(categoryDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 修改商品分类:验证商家是否有效
     *
     * @param categoryDTO 商品分类信息的入参封装
     * @return
     */
    @RequestMapping(value = "/category/update", method = RequestMethod.PUT)
    @Operation(summary = "修改商品分类:验证商家是否有效")
    @ResponseBody
    public RestResult<Boolean> updateCategory(@RequestBody @Validated(UpdateGroup.class) CategoryDTO categoryDTO) {
        Boolean result = productService.updateCategory(categoryDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 删除商品分类:验证商家是否有效
     *
     * @param categoryDTO 商品分类信息的入参封装
     * @return
     */
    @RequestMapping(value = "/category/delete", method = RequestMethod.DELETE)
    @Operation(summary = "删除商品分类:验证商家是否有效")
    @ResponseBody
    public RestResult<Boolean> deleteCategory(@RequestBody @Validated(DeleteGroup.class) CategoryDTO categoryDTO) {
        Boolean result = productService.deleteCategory(categoryDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 浏览所有商品
     *
     * @param productQuery 商品查询的入参封装
     * @return
     */
//    @RequestMapping(value = "/browse", method = RequestMethod.GET)
//    @Operation(summary = "浏览所有商品")
//    public RestResult<PageResult<ProductDO>> browseProducts(@Validated(QueryGroup.class) ProductQuery productQuery) {
//        PageResult<ProductDO> result = productService.browseProducts(productQuery);
//        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
//    }

    /**
     * 搜索商品
     *
     * @param productQuery 商品查询的入参封装
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @Operation(summary = "搜索商品")
    public RestResult<PageResult<ProductDO>> searchProducts(@Validated(QueryGroup.class) ProductQuery productQuery) {
        PageResult<ProductDO> result = productService.searchProducts(productQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 查看商品详细信息: 根据商品ID查询商品信息、商家信息、商品分类信息、商品评论信息
     *
     * @param productQuery 商品查询的入参封装
     * @return
     */
    @RequestMapping(value = "/info1", method = RequestMethod.GET)
    @Operation(summary = "查看商品详细信息: 根据商品ID查询商品信息、商家信息、商品分类信息、商品评论信息")
    public RestResult<ProductDO> productInfo(@Validated(QueryGroup.class) ProductQuery productQuery) {
        ProductDO result = productService.productInfo(productQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 查看商品评论列表: 根据商品ID查询所有评论
     *
     * @param productQuery 商品查询的入参封装
     * @return
     */
    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    @Operation(summary = "查看商品评论列表: 根据商品ID查询所有评论")
    public RestResult<List<ProductReviewDO>> productReviews(@Validated(QueryGroup.class) ProductQuery productQuery) {
        List<ProductReviewDO> result = productService.productReviews(productQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 查看商品分类详细信息: 根据分类ID查询分类信息
     *
     * @param categoryQuery 商品分类查询的入参封装
     * @return
     */
    @RequestMapping(value = "/category1", method = RequestMethod.GET)
    @Operation(summary = "查看商品分类详细信息: 根据分类ID查询分类信息")
    public RestResult<CategoryDO> productCategory(@Validated(QueryGroup.class) CategoryQuery categoryQuery) {
        CategoryDO result = productService.productCategory(categoryQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }


}
