package com.btpj.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.btpj.monitor.entity.STemperatureInform;
import com.btpj.monitor.mapper.STemperatureInformMapper;
import com.btpj.monitor.service.ISTemperatureInformService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BTPJ
 * @since 2023-01-03
 */
@Service
public class STemperatureInformServiceImpl extends ServiceImpl<STemperatureInformMapper, STemperatureInform> implements ISTemperatureInformService {
    @Resource
    private STemperatureInformMapper temperatureInformMapper;

    @Override
    public STemperatureInform getLatestData() {
        QueryWrapper<STemperatureInform> wrapper = new QueryWrapper<>();
        wrapper.lambda().orderByDesc(STemperatureInform::getSTime).last("limit 1");
        List<STemperatureInform> list = temperatureInformMapper.selectList(wrapper);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<STemperatureInform> getList(String beginTime, String endTime) {
        QueryWrapper<STemperatureInform> wrapper = new QueryWrapper<>();
        if (beginTime != null) {
            wrapper.lambda().ge(STemperatureInform::getSTime, beginTime);
        }
        if (endTime != null) {
            wrapper.lambda().le(STemperatureInform::getSTime, endTime);
        }
        wrapper.lambda().orderByDesc(STemperatureInform::getSTime);
        return temperatureInformMapper.selectList(wrapper);
    }
}
