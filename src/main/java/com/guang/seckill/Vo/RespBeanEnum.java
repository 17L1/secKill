package com.guang.seckill.Vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.Getter;


/**
 * 公共返回对象枚举
 */


@AllArgsConstructor
@ToString
@Getter
public enum RespBeanEnum {
    //通用
    SUCCESS(200,"SUCCESS"), ERROR(500,"服务端异常"),
    //登录模块
    LOGIN_ERROR(500210,"用户名或密码输入错误"),
    MOBILE_ERROR(500211,"手机号码格式不正确");
    private final Integer code;
    private final String message;
}
