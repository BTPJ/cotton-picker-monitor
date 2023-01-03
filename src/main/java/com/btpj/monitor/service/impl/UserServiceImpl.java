package com.btpj.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.btpj.monitor.entity.User;
import com.btpj.monitor.mapper.UserMapper;
import com.btpj.monitor.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author BTPJ
 * @since 2023-01-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User getUserByName(String name) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(User::getName, name);
        return userMapper.selectOne(userQueryWrapper);
    }

    @Override
    public User login(String name, String password) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(User::getName, name);
        userQueryWrapper.lambda().eq(User::getPassword, password);
        return userMapper.selectOne(userQueryWrapper);
    }

    @Override
    public User getUserInfo(Long id) {
        return userMapper.selectById(id);
    }
}
