package com.secondhand1.dao;

import com.secondhand1.pojo.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户Mapper接口
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    UserDO selectByUsername(@Param("username") String username);

    /**
     * 根据邮箱查询用户信息
     * @param email 邮箱
     * @return 用户信息
     */
    UserDO selectByEmail(@Param("email") String email);

    /**
     * 根据用户名或邮箱查询用户信息
     * @param usernameOrEmail 用户名或邮箱
     * @return 用户信息
     */
    UserDO selectByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail);

    /**
     * 根据重置令牌查询用户信息
     * @param resetToken 重置令牌
     * @return 用户信息
     */
    UserDO selectByResetToken(@Param("resetToken") String resetToken);

    /**
     * 根据用户ID查询用户信息
     * @param userId 用户ID
     * @return 用户信息
     */
    UserDO selectById(@Param("userId") Integer userId);

    /**
     * 插入用户信息
     * @param userDO 用户信息
     * @return 影响行数
     */
    int insert(UserDO userDO);

    /**
     * 根据用户ID更新用户信息
     * @param userDO 用户信息
     * @return 影响行数
     */
    int updateById(UserDO userDO);

    /**
     * 根据用户ID删除用户信息
     * @param userId 用户ID
     * @return 影响行数
     */
    int deleteById(@Param("userId") Integer userId);

    /**
     * 验证邮箱是否已被其他用户使用
     *
     * @Param userId 用户ID
     * @Param email 邮箱
     * @Return 返回验证结果
     */
    boolean isEmailUsedByOtherUser(@Param("userId") Integer userId, @Param("email") String email);

    int updateById1(UserDO userDO);
}
