package com.btpj.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.btpj.monitor.entity.GpsInform;
import com.btpj.monitor.mapper.GpsInformMapper;
import com.btpj.monitor.service.IGpsInformService;
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
public class GpsInformServiceImpl extends ServiceImpl<GpsInformMapper, GpsInform> implements IGpsInformService {

    @Resource
    private GpsInformMapper mapper;

    @Override
    public List<GpsInform> getList(String beginTime, String endTime) {
        QueryWrapper<GpsInform> wrapper = new QueryWrapper<>();
        if (beginTime != null) {
            wrapper.lambda().ge(GpsInform::getSTime, beginTime);
        }
        if (endTime != null) {
            wrapper.lambda().le(GpsInform::getSTime, endTime);
        }
        wrapper.lambda().orderByDesc(GpsInform::getSTime);
        return mapper.selectList(wrapper);
    }
}
