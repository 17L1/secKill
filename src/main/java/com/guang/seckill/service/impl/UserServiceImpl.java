package com.guang.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guang.seckill.Vo.LoginVo;
import com.guang.seckill.Vo.RespBean;
import com.guang.seckill.Vo.RespBeanEnum;
import com.guang.seckill.mapper.UserMapper;
import com.guang.seckill.pojo.User;
import com.guang.seckill.service.IUserService;
import com.guang.seckill.utils.MD5Util;
import com.guang.seckill.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 17L1
 * @since 2021-04-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 登录逻辑
     * @param loginVo
     * @return
     */
    @Override
    public RespBean doLogin(LoginVo loginVo) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        if (!ValidatorUtil.isMobile(mobile)){
            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        }
        User user = userMapper.selectById(mobile);
        if (null == user){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        if (!MD5Util.formPassToDBPass(password,user.getSlat()).equals(user.getPassword())){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        return RespBean.success();
    }
}
