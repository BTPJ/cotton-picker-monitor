package com.btpj.monitor.entity.response;

import com.btpj.monitor.entity.*;
import lombok.Data;

import java.io.Serializable;

/**
 * 实时监测数据
 *
 * @author BTPJ  2023/1/4
 */
@Data
public class MonitorResp implements Serializable {
    /**
     * 一氧化碳
     */
    private CoGasInform co;

    /**
     * 火焰
     */
    private FireInform fire;

    /**
     * 水位
     */
    private WaterLevelInform water;

    /**
     * 温度
     */
    private STemperatureInform temperature;

    /**
     * 转速
     */
    private HallInform hall;
}
