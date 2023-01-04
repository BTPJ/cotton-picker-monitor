package com.btpj.monitor.service;

import com.btpj.monitor.entity.STemperatureInform;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author BTPJ
 * @since 2023-01-03
 */
public interface ISTemperatureInformService extends IService<STemperatureInform> {

    /**
     * 获取最近一条数据
     * @return 最近一条数据
     */
    STemperatureInform getLatestData();
}
