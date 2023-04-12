package com.zzx.auth.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzx.auth.mapper.SysMenuMapper;
import com.zzx.auth.mapper.SysRoleMapper;
import com.zzx.auth.mapper.SysUserRoleMapper;
import com.zzx.auth.service.SysMenuService;
import com.zzx.auth.service.SysRoleService;
import com.zzx.auth.utils.MenuHelper;
import com.zzx.model.system.SysMenu;
import com.zzx.model.system.SysRole;
import com.zzx.model.system.SysUserRole;
import com.zzx.model.vo.AssginRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> findNodes() {
         //全部权限列表
        List<SysMenu> sysMenuList=sysMenuMapper.selectList(null);
        if(sysMenuList.isEmpty()) return null;

        //构建树形结构
        List<SysMenu> result= MenuHelper.buidTree(sysMenuList);

        return  result;
    }
}
