package com.btpj.monitor.service;

import com.btpj.monitor.entity.WaterLevelInform;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
