package com.meriem.app.repo.api.impl;


import com.meriem.app.repo.api.UmsUserRepository;
import cn.org.thinkcloud.repo.base.service.api.impl.BaseRepositoryImpl;
import org.apache.dubbo.config.annotation.DubboService;
import com.meriem.app.domain.UmsUser;
import com.meriem.app.repo.mapper.UmsUserMapper;

/**
 * @author : zhangqian9158@gmail.com
 */
@DubboService(version = "1.0.0")
public class UmsUserRepositoryImpl extends BaseRepositoryImpl<UmsUserMapper, UmsUser> implements UmsUserRepository {

}
