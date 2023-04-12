package com.zzx.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzx.model.system.SysMenu;

import java.util.List;

public interface SysMenuService extends IService<SysMenu> {
    List<SysMenu> findNodes();
}
