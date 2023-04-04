package com.zzx.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zzx.model.base.BaseEntity;
import lombok.Data;

@Data
@TableName("sys_user_role")
public class SysUserRole extends BaseEntity {

    @TableField("id")
    private Long id;
    @TableField("role_id")
    private Long roleId;
    @TableField("user_id")
    private Long userId;
}
