package com.guang.seckill.controller;

import com.guang.seckill.Vo.LoginVo;
import com.guang.seckill.Vo.RespBean;
import com.guang.seckill.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/login")
@Controller
@Slf4j
public class LoginController {

    @Autowired
    private IUserService userService;
    /**
     * 跳转登录页面
     */
    @RequestMapping("/toLogin")
    public String toLogin(){

        return "login";
    }

    /**
     * 登录功能
     * @param loginVo
     * @return
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(LoginVo loginVo){

        return RespBean.success(userService.doLogin(loginVo));
    }
}
