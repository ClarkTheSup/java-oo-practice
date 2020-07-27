package com.twu.beans;

import com.twu.role.Admin;
import com.twu.role.Role;
import com.twu.role.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RoleLogin {
    //添加不同类型用户
    List<Role> roleList;

    public RoleLogin() {
        this.roleList = new ArrayList<Role>();
        //手动添加用户
        roleList.add(new User("lkn"));
        roleList.add(new Admin("123"));
    }

    //登录成功则返回role的引用
    public Role login() {
        //命令行输入用户名
        String loginRoleName;
        System.out.print("请输入用户名：");
        Scanner scanner = new Scanner(System.in);
        loginRoleName = scanner.next();

        //根据输入的用户名找出RoleList中的角色
        Role loginRole;
        List selectLoginList = roleList.stream().filter(
                role -> role.getName().equals(loginRoleName)).collect(Collectors.toList());
        if (selectLoginList.size() > 1) {
            System.out.print("用户数量异常！");
            return null;
        } else if (selectLoginList.size() <= 0) {
            System.out.print("用户不存在！");
            return null;
        } else {
            loginRole = (Role) selectLoginList.get(0);
        }

        return loginRole;
    }
}
