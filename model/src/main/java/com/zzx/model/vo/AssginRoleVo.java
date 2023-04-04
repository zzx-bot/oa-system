package com.zzx.model.vo;

public class AssginRoleVo {
    private Long roleId;

    private Long userId;
    private Long[] roleIdList;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long[] getRoleIdList() {
     return roleIdList;
    }
}
