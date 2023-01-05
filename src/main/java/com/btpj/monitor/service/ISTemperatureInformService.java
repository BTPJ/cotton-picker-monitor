package com.btpj.monitor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.btpj.monitor.entity.STemperatureInform;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author BTPJ
 * @since 2023-01-03
 */
public interface ISTemperatureInformService extends IService<STemperatureInform> {

    /**
     * 获取最近一条数据
     *
     * @return 最近一条数据
     */
    STemperatureInform getLatestData();

    /**
     * 获取列表数据
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return 列表数据
     */
    List<STemperatureInform> getList(String beginTime, String endTime);
}
