package com.zzx.model.vo;

import com.zzx.model.base.BaseEntity;

public class SysRoleQueryVo extends BaseEntity {
    private static final long serialVersionUID=1L;
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
