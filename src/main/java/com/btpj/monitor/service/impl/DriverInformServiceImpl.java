package com.btpj.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.btpj.monitor.entity.DriverInform;
import com.btpj.monitor.mapper.DriverInformMapper;
import com.btpj.monitor.service.IDriverInformService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author BTPJ
 * @since 2023-01-03
 */
@Service
public class DriverInformServiceImpl extends ServiceImpl<DriverInformMapper, DriverInform> implements IDriverInformService {

    @Resource
    private DriverInformMapper mapper;

}
