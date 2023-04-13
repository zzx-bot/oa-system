package com.zzx.auth.controller;

import com.zzx.auth.service.SysMenuService;
import com.zzx.common.result.Result;
import com.zzx.model.system.SysMenu;
import com.zzx.vo.system.AssginMenuVo;
import com.zzx.vo.system.AssginRoleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "菜单管理")
@RestController
@RequestMapping("/admin/system/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuServices;

    @ApiOperation("查询所有菜单和角色分配的菜单")
    @GetMapping("/toAssign/{roleId}")
    public Result toAssign(@PathVariable Long roleId) {
        List<SysMenu> sysMenuList = sysMenuServices.findMenuByRoleId(roleId);
        var s = Result.ok(sysMenuList);
        return s;
    }

    @ApiOperation("角色分配菜单")
    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssginMenuVo assginMenuVo) {
        sysMenuServices.doAssign(assginMenuVo);
        return Result.ok();
    }

    /**
     * 菜单list
     */
    @ApiOperation(value = "展示菜单列表")
    @GetMapping("/list")
    public Result list() {
        List<SysMenu> sysMenuList = sysMenuServices.findNodes();
        return Result.ok(sysMenuList);
    }

    /**
     * 新增菜单
     */
    @ApiOperation(value = "新增菜单")
    @PostMapping("/save")
    public Result save(@RequestBody SysMenu sysMenu) {

        sysMenuServices.save(sysMenu);
        return Result.ok();
    }

    /**
     * 修改菜单
     */
    @ApiOperation(value = "修改菜单")
    @PutMapping("/update")
    public Result update(@RequestBody SysMenu sysMenu) {

        sysMenuServices.updateById(sysMenu);
        return Result.ok();
    }

    /**
     * 删除菜单
     */
    @ApiOperation(value = "删除菜单")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        sysMenuServices.removeById(id);
        return Result.ok();
    }
}
