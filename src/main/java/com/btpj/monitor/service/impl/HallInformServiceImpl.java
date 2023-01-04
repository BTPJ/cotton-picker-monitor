package com.btpj.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.btpj.monitor.entity.CoGasInform;
import com.btpj.monitor.entity.FireInform;
import com.btpj.monitor.entity.HallInform;
import com.btpj.monitor.mapper.CoGasInformMapper;
import com.btpj.monitor.mapper.HallInformMapper;
import com.btpj.monitor.service.IHallInformService;
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
public class HallInformServiceImpl extends ServiceImpl<HallInformMapper, HallInform> implements IHallInformService {
    @Resource
    private HallInformMapper hallInformMapper;

    @Override
    public HallInform getLatestData() {
        QueryWrapper<HallInform> wrapper = new QueryWrapper<>();
        wrapper.lambda().orderByDesc(HallInform::getSTime).last("limit 1");
        List<HallInform> list = hallInformMapper.selectList(wrapper);
        return list.isEmpty() ? null : list.get(0);
    }
}
