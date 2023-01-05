package com.btpj.monitor.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.btpj.monitor.entity.DriverInform;
import com.btpj.monitor.entity.FireInform;
import com.btpj.monitor.entity.response.BaseResp;
import com.btpj.monitor.service.IDriverInformService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author BTPJ
 * @since 2023-01-03
 */
@Api(tags = "设备相关接口")
@RestController
@RequestMapping("/driverInform")
public class DriverInformController {

    @Resource
    private IDriverInformService service;

    @ApiOperation(value = "获取分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页码", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", dataType = "String")
    })
    @GetMapping("/page")
    public BaseResp<Page<DriverInform>> getPageList(Integer pageSize, Integer pageNo) {
        Page<DriverInform> page = new Page<>(pageNo, pageSize == null ? 10 : pageSize);
        return BaseResp.success(service.page(page));
    }
}
