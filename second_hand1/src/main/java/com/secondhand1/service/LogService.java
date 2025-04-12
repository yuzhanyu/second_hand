package com.secondhand1.service;

import com.secondhand1.pojo.domain.LogDO;
import com.secondhand1.pojo.query.LogQuery;
import com.secondhand1.pojo.vo.PageResult;
import java.lang.Long;

/**
 * 系统日志管理
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
public interface LogService {

    /**
     * 查询用户操作日志
     *
     * @param query 日志查询参数
     * @return
     */
    PageResult<LogDO> userLogs(LogQuery query);

    /**
     * 查询商家操作日志
     *
     * @param query 日志查询参数
     * @return
     */
    PageResult<LogDO> merchantLogs(LogQuery query);

    /**
     * 查询所有系统日志
     *
     * @param query 日志查询参数
     * @return
     */
    PageResult<LogDO> allLogs(LogQuery query);

    /**
     * 查询系统日志详情
     *
     * @param logId
     * @return  系统日志实体类
     */
//    LogDO logDetail(Long logId);
}
