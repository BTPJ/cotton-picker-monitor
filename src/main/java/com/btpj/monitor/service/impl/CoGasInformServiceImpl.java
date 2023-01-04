package com.btpj.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.btpj.monitor.entity.CoGasInform;
import com.btpj.monitor.mapper.CoGasInformMapper;
import com.btpj.monitor.service.ICoGasInformService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
}
