package com.btpj.monitor.service;

import com.btpj.monitor.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author BTPJ
 * @since 2023-01-03
 */
public interface IUserService extends IService<User> {

    /**
     * 根据用户名查找用户
     *
     * @param name 用户名
     * @return 用户对象User
     */
    User getUserByName(String name);

    /**
     * 用户登录
     * @param name 用户名
     * @param password 密码
     * @return 用户登录信息
     */
    User login(String name,String password);

    /**
     * 获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    User getUserInfo(Long id);
}
