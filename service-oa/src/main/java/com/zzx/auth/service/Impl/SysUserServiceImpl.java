package com.zzx.auth.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzx.auth.mapper.SystemUserMapper;
import com.zzx.auth.service.SysUserService;
import com.zzx.model.system.SysUser;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SystemUserMapper, SysUser> implements SysUserService {
    @Override
    public void updateStatus(Long id, Integer status) {
        SysUser sysUser = this.getById(id);
        if(status.intValue() == 1) {
            sysUser.setStatus(status);
        } else {
            sysUser.setStatus(0);
        }
        this.updateById(sysUser);
    }
}
