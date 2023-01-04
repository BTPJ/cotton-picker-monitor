package com.btpj.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.btpj.monitor.entity.CoGasInform;
import com.btpj.monitor.entity.STemperatureInform;
import com.btpj.monitor.mapper.CoGasInformMapper;
import com.btpj.monitor.mapper.STemperatureInformMapper;
import com.btpj.monitor.service.ISTemperatureInformService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
}
