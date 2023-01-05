package com.btpj.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.btpj.monitor.entity.CoGasInform;
import com.btpj.monitor.mapper.CoGasInformMapper;
import com.btpj.monitor.service.ICoGasInformService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author BTPJ
 * @since 2023-01-03
 */
@Service
public class CoGasInformServiceImpl extends ServiceImpl<CoGasInformMapper, CoGasInform> implements ICoGasInformService {

    @Resource
    private CoGasInformMapper coGasInformMapper;

    @Override
    public CoGasInform getLatestData() {
        QueryWrapper<CoGasInform> wrapper = new QueryWrapper<>();
        wrapper.lambda().orderByDesc(CoGasInform::getSTime).last("limit 1");
        List<CoGasInform> list = coGasInformMapper.selectList(wrapper);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<CoGasInform> getList(String beginTime, String endTime) {
        QueryWrapper<CoGasInform> wrapper = new QueryWrapper<>();
        if (beginTime != null) {
            wrapper.lambda().ge(CoGasInform::getSTime, beginTime);
        }
        if (endTime != null) {
            wrapper.lambda().le(CoGasInform::getSTime, endTime);
        }
        wrapper.lambda().orderByDesc(CoGasInform::getSTime);
        return coGasInformMapper.selectList(wrapper);
    }
}
