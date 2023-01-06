package com.btpj.monitor.controller;

import com.btpj.monitor.entity.GpsInform;
import com.btpj.monitor.entity.response.BaseResp;
import com.btpj.monitor.service.IGpsInformService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author BTPJ
 * @since 2023-01-03
 */
@RestController
@RequestMapping("/gpsInform")
public class GpsInformController {

    @Resource
    private IGpsInformService service;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "beginTime", value = "开始时间", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", paramType = "query", dataType = "String")
    })
    @GetMapping("/list")
    public BaseResp<List<GpsInform>> getList(String beginTime, String endTime) {
        return BaseResp.success(service.getList(beginTime, endTime));
    }
}
