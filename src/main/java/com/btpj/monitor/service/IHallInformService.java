package com.btpj.monitor.service;

import com.btpj.monitor.entity.HallInform;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author BTPJ
 * @since 2023-01-03
 */
public interface IHallInformService extends IService<HallInform> {

    /**
     * 获取最近一条数据
     * @return 最近一条数据
     */
    HallInform getLatestData();
}
