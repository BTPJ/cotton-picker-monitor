package com.btpj.monitor.service;

import com.btpj.monitor.entity.FireInform;
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
public interface IFireInformService extends IService<FireInform> {

    /**
     * 获取最近一条数据
     *
     * @return 最近一条数据
     */
    FireInform getLatestData();

    /**
     * 获取列表数据
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return 列表数据
     */
    List<FireInform> getList(String beginTime, String endTime);
}
