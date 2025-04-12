package com.secondhand1.dao;

import com.secondhand1.pojo.domain.MerchantDO;
import org.apache.ibatis.annotations.Param;

/**
 * MerchantMapper
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface MerchantMapper {

    /**
     * 根据用户名或邮箱查询商家信息
     *
     * @Param username
     * @Param email
     * @Return MerchantDO
     */
    MerchantDO selectByUsernameOrEmail(String username, String email);

    /**
     * 根据重置令牌查询商家信息
     *
     * @Param resetToken
     * @Return MerchantDO
     */
    MerchantDO selectByResetToken(String resetToken);

    /**
     * 插入商家信息
     *
     * @Param merchantDO
     * @Return 影响行数
     */
    int insert(MerchantDO merchantDO);

    /**
     * 根据商家ID更新商家信息
     *
     * @Param merchantDO
     * @Return 影响行数
     */
    int updateById(MerchantDO merchantDO);

    /**
     * 根据ID查询商家信息
     *
     * @Param merchant_id
     * @Return MerchantDO
     */
    MerchantDO selectById(Integer merchant_id);

    /**
     * 验证邮箱是否已被其他商家使用
     *
     * @Param merchantId 商家ID
     * @Param email 邮箱
     * @Return 返回验证结果
     */
    boolean isEmailUsedByOtherMerchant(@Param("merchantId") Integer merchantId, @Param("email") String email);

    void updateById1(MerchantDO merchantDO);
}
