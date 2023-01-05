package com.btpj.monitor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.btpj.monitor.entity.WaterLevelInform;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author BTPJ
 * @since 2023-01-03
 */
public interface IWaterLevelInformService extends IService<WaterLevelInform> {

    /**
     * 获取最近一条数据
     * @return 最近一条数据
     */
    WaterLevelInform getLatestData();

    /**
     * 获取列表数据
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return 列表数据
     */
    List<WaterLevelInform> getList(String beginTime, String endTime);
}
