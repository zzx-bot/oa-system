package com.zzx.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzx.model.system.SysMenu;
import com.zzx.vo.system.AssginMenuVo;
import com.zzx.vo.system.AssginRoleVo;

import java.io.Serializable;
import java.util.List;

public interface SysMenuService extends IService<SysMenu> {
    List<SysMenu> findNodes();

    boolean removeById(Serializable id);

    //    查询所有菜单  角色权限菜单
    List<SysMenu> findMenuByRoleId(Long roleId);


    void doAssign(AssginMenuVo assginRoleVo);
}
