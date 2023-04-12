package com.zzx.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzx.model.system.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
}
