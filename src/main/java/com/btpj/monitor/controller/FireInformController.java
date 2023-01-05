package com.btpj.monitor.controller;

import com.btpj.monitor.entity.FireInform;
import com.btpj.monitor.entity.response.BaseResp;
import com.btpj.monitor.entity.response.MonitorResp;
import com.btpj.monitor.service.IFireInformService;
import io.swagger.annotations.Api;
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
 * 前端控制器
 * </p>
 *
 * @author BTPJ
 * @since 2023-01-03
 */
@Api(tags = "火焰相关接口")
@RestController
@RequestMapping("/fireInform")
public class FireInformController {
    @Resource
    private IFireInformService fireInformService;

    @ApiOperation(value = "获取历史监测数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "beginTime", value = "开始时间", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", paramType = "query", dataType = "String")
    })
    @GetMapping("/list")
    public BaseResp<List<FireInform>> getMonitorLatestData(String beginTime, String endTime) {
        return BaseResp.success(fireInformService.getList(beginTime, endTime), "获取历史监测数据成功");
    }
}
