package com.btpj.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.btpj.monitor.entity.CoGasInform;
import com.btpj.monitor.entity.FireInform;
import com.btpj.monitor.mapper.CoGasInformMapper;
import com.btpj.monitor.mapper.FireInformMapper;
import com.btpj.monitor.service.IFireInformService;
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
public class FireInformServiceImpl extends ServiceImpl<FireInformMapper, FireInform> implements IFireInformService {
    @Resource
    private FireInformMapper fireInformMapper;

    @Override
    public FireInform getLatestData() {
        QueryWrapper<FireInform> wrapper = new QueryWrapper<>();
        wrapper.lambda().orderByDesc(FireInform::getSTime).last("limit 1");
        List<FireInform> list = fireInformMapper.selectList(wrapper);
        return list.isEmpty() ? null : list.get(0);
    }
}
