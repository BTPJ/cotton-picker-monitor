package com.btpj.monitor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.btpj.monitor.entity.GpsInform;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author BTPJ
 * @since 2023-01-03
 */
public interface IGpsInformService extends IService<GpsInform> {
    /**
     * 获取列表数据
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return 列表数据
     */
    List<GpsInform> getList(String beginTime, String endTime);
}
