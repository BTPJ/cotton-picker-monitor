package com.btpj.monitor.service;

import com.btpj.monitor.entity.HallInform;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author BTPJ
 * @since 2023-01-03
 */
public interface IHallInformService extends IService<HallInform> {

    /**
     * 获取最近一条数据
     *
     * @return 最近一条数据
     */
    HallInform getLatestData();

    /**
     * 获取列表数据
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return 列表数据
     */
    List<HallInform> getList(String beginTime, String endTime);
}
