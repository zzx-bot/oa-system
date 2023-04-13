package com.zzx.auth.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzx.auth.mapper.SysMenuMapper;
import com.zzx.auth.mapper.SysRoleMenuMapper;
import com.zzx.auth.service.SysMenuService;
import com.zzx.auth.utils.MenuHelper;
import com.zzx.common.execption.GuiguException;
import com.zzx.model.system.SysMenu;
import com.zzx.model.system.SysRoleMenu;
import com.zzx.model.system.SysUserRole;
import com.zzx.vo.system.AssginMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public List<SysMenu> findNodes() {
        //全部权限列表
        List<SysMenu> sysMenuList = sysMenuMapper.selectList(null);
        if (sysMenuList.isEmpty()) return null;

        //构建树形结构
        List<SysMenu> result = MenuHelper.buidTree(sysMenuList);

        return result;
    }

    @Override
    public boolean removeById(Serializable id) {
        int count = this.count(new LambdaQueryWrapper<SysMenu>().eq(SysMenu::getParentId, id));
        if (count > 0) {
            throw new GuiguException(201, "菜单不能删除");
        }
        sysMenuMapper.deleteById(id);
        return true;
    }

    @Override
    public List<SysMenu> findMenuByRoleId(Long roleId) {
        // 可用的菜单集合
        List<SysMenu> ableMenuList = sysMenuMapper
                .selectList(new LambdaQueryWrapper<SysMenu>()
                        .eq(SysMenu::getStatus, 1));

        //      角色拥有的菜单id
        List<SysRoleMenu> existSysRoleMenuList = sysRoleMenuMapper
                .selectList(new LambdaQueryWrapper<SysRoleMenu>()
                        .eq(SysRoleMenu::getRoleId, roleId)
                        .select(SysRoleMenu::getMenuId));

        List<Long> existMenuIdList = existSysRoleMenuList.stream()
                .map(c -> c.getMenuId())
                .collect(Collectors.toList());

        for (SysMenu menu : ableMenuList) {
            //已分配
            if (existMenuIdList.contains(menu.getId())) {
                menu.setSelect(true);
            } else menu.setSelect(false);
        }

        return MenuHelper.buidTree(ableMenuList);
    }

    @Override
    public void doAssign(AssginMenuVo assginMenuVo) {
        sysRoleMenuMapper.delete(new LambdaQueryWrapper<SysRoleMenu>()
                .eq(SysRoleMenu::getRoleId, assginMenuVo.getRoleId()));

        for (Long menuId : assginMenuVo.getMenuIdList()) {
            if (StringUtils.isEmpty(menuId)) continue;
            SysRoleMenu roleMenu = new SysRoleMenu();
            roleMenu.setRoleId(assginMenuVo.getRoleId());
            roleMenu.setMenuId(menuId);
            sysRoleMenuMapper.insert(roleMenu);
        }
    }
}
