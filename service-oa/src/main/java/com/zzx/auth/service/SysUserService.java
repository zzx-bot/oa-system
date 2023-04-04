package com.zzx.auth.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zzx.model.system.SysRole;
import com.zzx.model.system.SysUser;

public interface SysUserService extends IService<SysUser> {

    void updateStatus(Long id, Integer status);
}

