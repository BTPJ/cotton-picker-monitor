package com.btpj.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.btpj.monitor.entity.WaterLevelInform;
import com.btpj.monitor.mapper.WaterLevelInformMapper;
import com.btpj.monitor.service.IWaterLevelInformService;
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
public class WaterLevelInformServiceImpl extends ServiceImpl<WaterLevelInformMapper, WaterLevelInform> implements IWaterLevelInformService {
    @Resource
    private WaterLevelInformMapper waterLevelInformMapper;

    @Override
    public WaterLevelInform getLatestData() {
        QueryWrapper<WaterLevelInform> wrapper = new QueryWrapper<>();
        wrapper.lambda().orderByDesc(WaterLevelInform::getSTime).last("limit 1");
        List<WaterLevelInform> list = waterLevelInformMapper.selectList(wrapper);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<WaterLevelInform> getList(String beginTime, String endTime) {
        QueryWrapper<WaterLevelInform> wrapper = new QueryWrapper<>();
        if (beginTime != null) {
            wrapper.lambda().ge(WaterLevelInform::getSTime, beginTime);
        }
        if (endTime != null) {
            wrapper.lambda().le(WaterLevelInform::getSTime, endTime);
        }
        wrapper.lambda().orderByDesc(WaterLevelInform::getSTime);
        return waterLevelInformMapper.selectList(wrapper);
    }
}
