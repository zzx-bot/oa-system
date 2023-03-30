package com.zzx.auth.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzx.auth.mapper.SysRoleMapper;
import com.zzx.auth.service.SysRoleService;
import com.zzx.model.system.SysRole;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>implements SysRoleService {

}
