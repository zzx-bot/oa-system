package com.zzx.auth.utils;

import com.zzx.model.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

public class MenuHelper {
    public static List<SysMenu> buidTree(List<SysMenu> sysMenuList) {

        List<SysMenu> tree = new ArrayList<>();
        for (SysMenu menu : sysMenuList) {
            if (menu.getParentId() == 0)
                tree.add(getChildren(menu, sysMenuList));
        }

        return tree;
    }

    private static SysMenu getChildren(SysMenu parentMenu, List<SysMenu> sysMenuList) {
        if (parentMenu.getChildren() == null)
            parentMenu.setChildren(new ArrayList<>());

        for (SysMenu childMenu : sysMenuList) {
            if (childMenu.getParentId().longValue() == parentMenu.getId())
                parentMenu.getChildren().add(getChildren(childMenu, sysMenuList));
        }
        return parentMenu;
    }
}
