package com.secondhand1.constant;

import org.springframework.stereotype.Component;

import java.lang.String;

/**
 * 响应码常量
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@Component
public final class ResultCodeConstant {
  public static final String CODE_000001 = "000001";

  public static final String CODE_000001_MSG = "不存在";


  public static final String CODE_000000 = "000000";

  public static final String CODE_000000_MSG = "调用成功";

  public static final String CODE_999999 = "999999";

  public static final String CODE_999999_MSG = "系统异常";
}
