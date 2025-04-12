package com.secondhand1.service.impl;

import com.secondhand1.dao.LogMapper;
import com.secondhand1.pojo.domain.LogDO;
import com.secondhand1.pojo.query.LogQuery;
import com.secondhand1.pojo.vo.PageResult;
import com.secondhand1.service.LogService;
import java.lang.Long;
import java.lang.Override;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.secondhand1.exception.BusinessException;
import java.util.List;
import java.util.Map;
import com.secondhand1.constant.ResultCodeConstant;

/**
 * 系统日志管理的实现
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public PageResult<LogDO> userLogs(LogQuery query) {
        // 确保 pageSize 和 pageIndex 不为 null，提供默认值
        int defaultPageSize = 10; // 默认每页显示 10 条记录
        int defaultPageIndex = 1; // 默认页码为第 1 页

        int pageSize = (query.getPageSize() != null) ? query.getPageSize() : defaultPageSize;
        int pageIndex = (query.getPageIndex() != null) ? query.getPageIndex() : defaultPageIndex;

        // 查询所有日志
        List<LogDO> logs = logMapper.selectByUserId(query.getUserId());
        long totalRecords = logs.size();

        // 计算总页数
        long totalPages = (totalRecords + pageSize - 1) / pageSize;

        // 分页逻辑：提取当前页的数据
        int fromIndex = (pageIndex - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, (int) totalRecords);

        List<LogDO> pageLogs = logs.subList(fromIndex, toIndex);

        // 构造分页结果
        PageResult<LogDO> pageResult = new PageResult<>(totalRecords, totalPages, pageIndex, pageSize, pageLogs);
        return pageResult;
    }

    @Override
    public PageResult<LogDO> merchantLogs(LogQuery query) {
    // 确保 pageSize 不为 null，提供默认值（如 10）
    Integer pageSize = query.getPageSize() == null ? 10 : query.getPageSize();
    Integer pageIndex = query.getPageIndex() == null ? 1 : query.getPageIndex();

    List<LogDO> logs = logMapper.selectByMerchantId(query.getMerchantId());
    long totalRecords = logs.size();

    // 计算 totalPages，避免 pageSize 为 0 的情况
    long totalPages = pageSize > 0 ? (totalRecords / pageSize + (totalRecords % pageSize > 0L ? 1L : 0L)) : 0;

    // 分页逻辑
    int fromIndex = Math.max(0, (pageIndex - 1) * pageSize);
    int toIndex = Math.min(logs.size(), fromIndex + pageSize);
    List<LogDO> paginatedLogs = logs.subList(fromIndex, toIndex);

    PageResult<LogDO> pageResult = new PageResult<>(totalRecords, totalPages, pageIndex, pageSize, paginatedLogs);
    return pageResult;
}


    @Override
    public PageResult<LogDO> allLogs(LogQuery query) {
        // 确保 pageSize 和 pageIndex 不为 null，提供默认值
        int defaultPageSize = 10; // 默认每页显示 10 条记录
        int defaultPageIndex = 1; // 默认页码为第 1 页

        int pageSize = (query.getPageSize() != null) ? query.getPageSize() : defaultPageSize;
        int pageIndex = (query.getPageIndex() != null) ? query.getPageIndex() : defaultPageIndex;

        // 查询所有日志
        List<LogDO> logs = logMapper.selectAll();
        long totalRecords = logs.size();

        // 计算总页数
        long totalPages = (totalRecords + pageSize - 1) / pageSize;

        // 分页逻辑：提取当前页的数据
        int fromIndex = (pageIndex - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, (int) totalRecords);

        List<LogDO> pageLogs = logs.subList(fromIndex, toIndex);

        // 构造分页结果
        PageResult<LogDO> pageResult = new PageResult<>(totalRecords, totalPages, pageIndex, pageSize, pageLogs);
        return pageResult;
    }

//    @Override
//    public LogDO logDetail(Long logId) {
//        LogDO logDO = logMapper.selectById(logId);
//        if (logDO != null) {
//            return logDO;
//        }
//        throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
//    }
}
