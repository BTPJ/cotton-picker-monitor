package com.btpj.monitor.controller;

import com.btpj.monitor.entity.response.BaseResp;
import com.btpj.monitor.entity.response.MonitorResp;
import com.btpj.monitor.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author BTPJ
 * @since 2023-01-03
 */
@Api(tags = "实时数据相关接口")
@RestController
@RequestMapping("/monitor")
public class MonitorController {
    @Resource
    private ICoGasInformService coGasInformService;
    @Resource
    private IFireInformService fireInformService;
    @Resource
    private IWaterLevelInformService waterLevelInformService;
    @Resource
    private IHallInformService hallInformService;
    @Resource
    private ISTemperatureInformService temperatureInformService;

    @ApiOperation(value = "获取实时监测数据")
    @GetMapping("/latest")
    public BaseResp<MonitorResp> getMonitorLatestData() {
        MonitorResp monitorResp = new MonitorResp();
        monitorResp.setCo(coGasInformService.getLatestData());
        monitorResp.setFire(fireInformService.getLatestData());
        monitorResp.setWater(waterLevelInformService.getLatestData());
        monitorResp.setHall(hallInformService.getLatestData());
        monitorResp.setTemperature(temperatureInformService.getLatestData());
        return BaseResp.success(monitorResp, "获取实时监测数据成功");
    }
}
