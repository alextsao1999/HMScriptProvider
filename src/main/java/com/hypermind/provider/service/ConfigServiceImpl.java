package com.hypermind.provider.service;

import com.hypermind.provider.model.Config;
import com.hypermind.provider.mapper.ConfigMapper;
import com.hypermind.provider.service.iService.ConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 无间
 * @since 2019-10-20
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService {

}
