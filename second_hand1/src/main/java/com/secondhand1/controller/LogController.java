package com.secondhand1.controller;

import com.secondhand1.constant.ResultCodeConstant;
import com.secondhand1.pojo.domain.LogDO;
import com.secondhand1.pojo.dto.RestResult;
import com.secondhand1.pojo.query.LogQuery;
import com.secondhand1.pojo.query.QueryGroup;
import com.secondhand1.pojo.vo.PageResult;
import com.secondhand1.service.LogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Long;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统日志管理
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Tag(name = "系统日志管理")
@RequestMapping("log")
@RestController
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 查询用户操作日志
     *
     * @param query 日志查询参数
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @Operation(summary = "查询用户操作日志")
    public RestResult<PageResult<LogDO>> userLogs(@Validated(QueryGroup.class) LogQuery query) {
        PageResult<LogDO> result = logService.userLogs(query);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 查询商家操作日志
     *
     * @param query 日志查询参数
     * @return
     */
    @RequestMapping(value = "/merchant", method = RequestMethod.GET)
    @Operation(summary = "查询商家操作日志")
    public RestResult<PageResult<LogDO>> merchantLogs(@Validated(QueryGroup.class) LogQuery query) {
        PageResult<LogDO> result = logService.merchantLogs(query);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 查询所有系统日志
     *
     * @param query 日志查询参数
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @Operation(summary = "查询所有系统日志")
    public RestResult<PageResult<LogDO>> allLogs(@Validated(QueryGroup.class) LogQuery query) {
        PageResult<LogDO> result = logService.allLogs(query);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 查询系统日志详情
     *
     * @param logId
     * @return
     */
//    @RequestMapping(value = "/detail", method = RequestMethod.GET)
//    @Operation(summary = "查询系统日志详情")
//    public RestResult<LogDO> logDetail(@Validated Long logId) {
//        LogDO result = logService.logDetail(logId);
//        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
//    }
}
