package com.secondhand1.service.impl;

import com.secondhand1.dao.CategoryMapper;
import com.secondhand1.dao.MerchantMapper;
import com.secondhand1.dao.ProductMapper;
import com.secondhand1.dao.ProductReviewMapper;
import com.secondhand1.pojo.domain.CategoryDO;
import com.secondhand1.pojo.domain.ProductDO;
import com.secondhand1.pojo.domain.ProductReviewDO;
import com.secondhand1.pojo.dto.CategoryDTO;
import com.secondhand1.pojo.dto.ProductDTO;
import com.secondhand1.pojo.query.CategoryQuery;
import com.secondhand1.pojo.query.ProductQuery;
import com.secondhand1.pojo.vo.PageResult;
import com.secondhand1.service.ProductService;
import java.lang.Boolean;
import java.lang.Override;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.secondhand1.exception.BusinessException;
import com.secondhand1.pojo.domain.MerchantDO;
import java.util.Map;
import com.secondhand1.constant.ResultCodeConstant;

/**
 * 商品管理模块的实现
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductReviewMapper productReviewMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public Boolean addProduct(ProductDTO productDTO) {
        MerchantDO merchantDO = merchantMapper.selectById(productDTO.getMerchantId());
        if (merchantDO == null || !"active".equals(merchantDO.getStatus())) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        ProductDO productDO = new ProductDO();
        productDO.setMerchantId(productDTO.getMerchantId());
        productDO.setName(productDTO.getName());
        productDO.setDescription(productDTO.getDescription());
        productDO.setPrice(productDTO.getPrice());
        productDO.setStock(productDTO.getStock());
        productDO.setCategoryId(productDTO.getCategoryId());
        productDO.setStatus("active");
        productDO.setCreateBy(productDTO.getMerchantId());
        productDO.setCreateTime(new Date());
        productDO.setImage(productDTO.getImage());
        productMapper.insert(productDO);
        return true;
    }

    @Override
    public Boolean updateProduct(ProductDTO productDTO) {
        MerchantDO merchantDO = merchantMapper.selectById(productDTO.getMerchantId());
        if (merchantDO == null || !"active".equals(merchantDO.getStatus())) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        ProductDO existingProduct = productMapper.selectById(productDTO.getProductId());
        if (existingProduct == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        ProductDO productDO = new ProductDO();
        productDO.setProductId(productDTO.getProductId());
        productDO.setMerchantId(productDTO.getMerchantId());
        productDO.setName(productDTO.getName());
        productDO.setDescription(productDTO.getDescription());
        productDO.setPrice(productDTO.getPrice());
        productDO.setStock(productDTO.getStock());
        productDO.setCategoryId(productDTO.getCategoryId());
        productDO.setStatus(productDTO.getStatus());
        productDO.setImage(productDTO.getImage());
        productMapper.updateById(productDO);
        return true;
    }

    @Override
    public ProductDO getProductInfo(ProductQuery productQuery) {
        ProductDO productDO = productMapper.selectById(productQuery.getProductId());
        if (productDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        return productDO;
    }

    @Override
    public Boolean deleteProduct(ProductDTO productDTO) {
        MerchantDO merchantDO = merchantMapper.selectById(productDTO.getMerchantId());
        if (merchantDO == null || !"active".equals(merchantDO.getStatus())) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        ProductDO existingProduct = productMapper.selectById(productDTO.getProductId());
        if (existingProduct == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        productMapper.deleteById(productDTO.getProductId());
        return true;
    }

    @Override
    public List<ProductDO> getAllProducts() {
        List<ProductDO> productDOList = productMapper.selectAll();
        return productDOList;
    }

    @Override
    public List<ProductDO> getProductsByCategory(CategoryQuery categoryQuery) {
        CategoryDO categoryDO = categoryMapper.selectById(categoryQuery.getCategoryId());
        if (categoryDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        List<ProductDO> productDOList = productMapper.selectByCategoryId(categoryQuery.getCategoryId());
        return productDOList;
    }

    @Override
    public Boolean addCategory(CategoryDTO categoryDTO) {
        MerchantDO merchantDO = merchantMapper.selectById(categoryDTO.getMerchantId());
        if (merchantDO == null || !"active".equals(merchantDO.getStatus())) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        CategoryDO existingCategory = categoryMapper.selectByName(categoryDTO.getName());
        if (existingCategory != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        CategoryDO categoryDO = new CategoryDO();
        categoryDO.setCategoryId(categoryDTO.getCategoryId());
        categoryDO.setCreateBy(categoryDTO.getMerchantId());
        categoryDO.setName(categoryDTO.getName());
        categoryDO.setDescription(categoryDTO.getDescription());
        categoryDO.setCreateTime(new Date());
        categoryMapper.insert(categoryDO);
        System.out.println();
        return true;
    }

    @Override
    public Boolean updateCategory(CategoryDTO categoryDTO) {
        MerchantDO merchantDO = merchantMapper.selectById(categoryDTO.getMerchantId());
        if (merchantDO == null || !"active".equals(merchantDO.getStatus())) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        CategoryDO existingCategory = categoryMapper.selectById(categoryDTO.getCategoryId());
        if (existingCategory == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        CategoryDO categoryDO = new CategoryDO();
        categoryDO.setCategoryId(categoryDTO.getCategoryId());
        categoryDO.setMerchantId(categoryDTO.getMerchantId());
        categoryDO.setName(categoryDTO.getName());
        categoryDO.setDescription(categoryDTO.getDescription());
        categoryMapper.updateById(categoryDO);
        return true;
    }

    @Override
    public Boolean deleteCategory(CategoryDTO categoryDTO) {
        MerchantDO merchantDO = merchantMapper.selectById(categoryDTO.getMerchantId());
        if (merchantDO == null || !"active".equals(merchantDO.getStatus())) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        CategoryDO existingCategory = categoryMapper.selectById(categoryDTO.getCategoryId());
        if (existingCategory == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        categoryMapper.deleteById(categoryDTO.getCategoryId());
        return true;
    }


    @Override
    public PageResult<ProductDO> searchProducts(ProductQuery productQuery) {
        try {
            int totalRecords = productMapper.countActiveProductsByKeyword(productQuery.getKeyword());
            // 计算偏移量
            int offset = (productQuery.getPage() - 1) * productQuery.getPageSize();

            // 查询分页数据
            List<ProductDO> products = productMapper.getActiveProductsByKeywordAndPage(productQuery.getKeyword(), offset, productQuery.getPageSize());
            long totalPages = totalRecords / productQuery.getPageSize() + (totalRecords % productQuery.getPageSize() > 0L ? 1L : 0L);
            PageResult<ProductDO> pageResult = new PageResult<>(totalRecords, totalPages, productQuery.getPage(), productQuery.getPageSize(), products);
            return pageResult;
        } catch (Exception e) {
            throw new BusinessException(ResultCodeConstant.CODE_999999, ResultCodeConstant.CODE_999999_MSG);
        }
    }

    @Override
    public ProductDO productInfo(ProductQuery productQuery) {
        ProductDO product = productMapper.selectById(productQuery.getProductId());
        if (product == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        MerchantDO merchant = merchantMapper.selectById(product.getMerchantId());
        CategoryDO category = categoryMapper.selectById(product.getCategoryId());
        List<ProductReviewDO> reviews = productReviewMapper.selectAllByProductId(product.getProductId());
        product.setMerchant(merchant);
        product.setCategory(category);
        product.setReviews(reviews);
        return product;
    }

    @Override
    public List<ProductReviewDO> productReviews(ProductQuery productQuery) {
        List<ProductReviewDO> reviews = productReviewMapper.selectAllByProductId(productQuery.getProductId());
        if (reviews.isEmpty()) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        return reviews;
    }

    @Override
    public CategoryDO productCategory(CategoryQuery categoryQuery) {
        CategoryDO category = categoryMapper.selectById(categoryQuery.getCategoryId());
        if (category == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        return category;
    }

    @Override
    public List<CategoryDO> getAllCategory() {
        List<CategoryDO> categoryDOList = categoryMapper.selectAllCategories();
        if (categoryDOList == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);

        }
        return categoryDOList;
    }
}
