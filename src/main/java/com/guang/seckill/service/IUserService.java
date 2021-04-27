package com.guang.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guang.seckill.Vo.LoginVo;
import com.guang.seckill.Vo.RespBean;
import com.guang.seckill.pojo.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 17L1
 * @since 2021-04-27
 */
public interface IUserService extends IService<User> {
    /**
     * 登录接口
     * @param loginVo
     * @return
     */
    RespBean doLogin(LoginVo loginVo);
}
