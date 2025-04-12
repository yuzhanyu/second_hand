package com.secondhand1.dao;

import com.secondhand1.pojo.domain.LogDO;
import java.util.List;

/**
 * LogMapper
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface LogMapper {

    /**
     * 根据用户ID查询日志
     * @param userId 用户ID
     * @return 日志集合
     */
    List<LogDO> selectByUserId(Integer userId);

    /**
     * 根据商家ID查询日志
     * @param merchantId 商家ID
     * @return 日志集合
     */
    List<LogDO> selectByMerchantId(Integer merchantId);

    /**
     * 查询所有日志
     * @return 日志集合
     */
    List<LogDO> selectAll();

    /**
     * 根据日志ID查询日志
     * @param logId 日志ID
     * @return 日志实体
     */
    LogDO selectById(Long logId);
}
