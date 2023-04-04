package com.zzx.model.system;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zzx.model.base.BaseEntity;
import io.swagger.models.auth.In;
import lombok.Data;

@Data
@TableName("sys_user")
public class SysUser extends BaseEntity {
    private static final long serialVersionUID=1L;

    @TableId(type = IdType.AUTO)
    private Long id;
    //用户名
    @TableField("username")
    private String userName;

    @TableField("password")
    private String password;

    @TableField("name")
    private String name;

    @TableField("phone")
    private String phone;
    @TableField("status")
    private Integer status;


    @TableField("create_time")
    private String createTime;
}
