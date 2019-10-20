package com.hypermind.provider.service;

import com.hypermind.provider.model.Scripts;
import com.hypermind.provider.mapper.ScriptsMapper;
import com.hypermind.provider.service.iService.ScriptsService;
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
public class ScriptsServiceImpl extends ServiceImpl<ScriptsMapper, Scripts> implements ScriptsService {

}
