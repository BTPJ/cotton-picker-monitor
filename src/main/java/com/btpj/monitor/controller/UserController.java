package com.btpj.monitor.controller;

import com.btpj.monitor.entity.User;
import com.btpj.monitor.entity.response.BaseResp;
import com.btpj.monitor.entity.response.UserResp;
import com.btpj.monitor.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author BTPJ
 * @since 2023-01-03
 */
@Api(tags = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @ApiOperation(value = "登录", notes = "输入用户名和密码进行登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", dataType = "String", required = true)
    })
    @PostMapping("/login")
    public BaseResp<UserResp> login(@RequestParam @Validated @NotBlank(message = "用户名不可为空") String name,
                                    @RequestParam @Validated @NotBlank(message = "密码不可为空") String password) {
        if (userService.getUserByName(name) == null) {
            return BaseResp.error("用户不存在");
        }
        User user = userService.login(name, password);
        if (user == null) {
            return BaseResp.error("密码错误");
        } else {
            UserResp userResp = new UserResp();
            BeanUtils.copyProperties(user, userResp);
            return BaseResp.success(userResp, "登录成功");
        }
    }

    @ApiOperation(value = "获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", paramType = "path", dataType = "String", required = true)
    })
    @GetMapping("/info/{id}")
    public BaseResp<UserResp> getUserInfo(@PathVariable Long id) {
        User user = userService.getUserInfo(id);
        UserResp userResp = new UserResp();
        BeanUtils.copyProperties(user, userResp);
        userResp.setRoles("admin");
        return BaseResp.success(userResp, "获取用户信息成功");
    }
}
