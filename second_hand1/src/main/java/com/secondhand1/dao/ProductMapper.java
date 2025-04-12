package com.secondhand1.dao;

import java.util.List;
import com.secondhand1.pojo.domain.ProductDO;
import com.secondhand1.pojo.query.QueryGroup;
import jakarta.validation.constraints.NotBlank;
import org.apache.ibatis.annotations.Param;
import com.secondhand1.pojo.domain.CategoryDO;

/**
 * ProductMapper
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface ProductMapper {

    /**
     * 根据ID查询商品信息
     *
     * @Param productId
     * @Return ProductDO
     */
    ProductDO selectById(Integer productId);

    /**
     * 根据分类ID查询商品列表
     *
     * @Param categoryId
     * @Return List<ProductDO>
     */
    List<ProductDO> selectByCategoryId(Integer categoryId);

    /**
     * 查询所有商品信息
     *
     * @Param 无
     * @Return List<ProductDO>
     */
    List<ProductDO> selectAll();

    /**
     * 插入商品信息
     *
     * @Param productDO
     * @Return int
     */
    int insert(ProductDO productDO);

    /**
     * 更新商品信息
     *
     * @Param productDO
     * @Return int
     */
    int updateById(ProductDO productDO);

    /**
     * 删除商品信息
     *
     * @Param productId
     * @Return int
     */
    int deleteById(Integer productId);

    /**
     * 统计所有状态为active的商品数量
     * @return 商品数量
     */
    int countActiveProducts();

    /**
     * 根据页码和每页显示数量查询所有状态为active的商品
     * @param page 页码
     * @param pageSize 每页显示数量
     * @return 商品列表
     */
    List<ProductDO> getActiveProductsByPage(int page, int pageSize);

    /**
     * 统计所有状态为active且名称包含关键词的商品数量
     * @param keyword 关键词
     * @return 商品数量
     */
    int countActiveProductsByKeyword(String keyword);

    /**
     * 根据关键词、页码和每页显示数量查询状态为active的商品
     * @param keyword 关键词
     * @param page 页码
     * @param pageSize 每页显示数量
     * @return 商品列表
     */
    List<ProductDO> getActiveProductsByKeywordAndPage(String keyword, int page, int pageSize);

    /**
     * 根据商家ID查询商品信息
     *
     * @Param merchantId 商家ID
     * @Return List<ProductDO> 商品信息列表
     */
    List<ProductDO> selectByMerchantId(Integer merchantId);

    /**
     * 获取所有商品分类信息
     *
     * @Return List<CategoryDO> 分类信息列表
     */
    List<CategoryDO> selectAllCategories();

    List<ProductDO> getActiveProductsByKeywordAndPage1(@NotBlank(groups = { QueryGroup.class }, message = "关键词不能为空") String keyword);
}
