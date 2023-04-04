package com.zzx.auth.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzx.auth.service.SysRoleService;
import com.zzx.model.system.SysRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class SysRoleMapperTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleService sysRoleService;


    @Test
    public void testSelectList() {
        System.out.println(("----- selectAll method test ------"));
        //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper
        //所以不填写就是无任何条件
        sysRoleService.list(null).forEach(System.out::println);

    }

    @Test
    public void testQueryWrapper(){
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_code", "SYSTEM");
        List<SysRole> sysRoles = sysRoleMapper.selectList(queryWrapper);
        System.out.println(sysRoles);
    }

//    @Test
//    public void testLambdaQueryWrapper(){
//
//        List<SysRole> sysRoles = sysRoleMapper.selectList(
//                new LambdaQueryWrapper<>().ge("role_code", "role"));
//        System.out.println(sysRoles);
//    }
}
