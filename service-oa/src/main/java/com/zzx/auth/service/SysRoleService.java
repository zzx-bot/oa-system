package com.zzx.auth.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zzx.model.system.SysRole;
import com.zzx.model.vo.AssginRoleVo;

import java.util.List;
import java.util.Map;

public interface SysRoleService extends IService<SysRole> {
    /**
     * 根据用户获取角色数据
     * @param userId
     * @return
     */
    Map<String, Object> findRoleByAdminId(Long userId);

    /**
     * 分配角色
     * @param assginRoleVo
     */
    void doAssign(AssginRoleVo assginRoleVo);
}

