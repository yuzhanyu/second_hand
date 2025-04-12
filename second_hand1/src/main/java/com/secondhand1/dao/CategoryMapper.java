package com.secondhand1.dao;

import com.secondhand1.pojo.domain.CategoryDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * CategoryMapper
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface CategoryMapper {

    /**
     * 根据ID查询分类信息
     *
     * @Param categoryId
     * @Return CategoryDO
     */
    CategoryDO selectById(Integer categoryId);

    /**
     * 根据名称查询分类信息
     *
     * @Param name
     * @Return CategoryDO
     */
    CategoryDO selectByName(String name);

    /**
     * 插入分类信息
     *
     * @Param categoryDO
     * @Return int
     */
    int insert(CategoryDO categoryDO);

    /**
     * 更新分类信息
     *
     * @Param categoryDO
     * @Return int
     */
    int updateById(CategoryDO categoryDO);

    /**
     * 删除分类信息
     *
     * @Param categoryId
     * @Return int
     */
    int deleteById(Integer categoryId);

    List<CategoryDO> selectAllCategories();
}
