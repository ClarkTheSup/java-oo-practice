package com.twu.controller;

import com.twu.beans.RoleLogin;
import com.twu.role.Admin;
import com.twu.role.Role;
import com.twu.role.User;
import com.twu.view.AdminView;
import com.twu.view.UserView;

//对登录时的命令进行控制，不属于CommandController
public class LoginCommandController extends CommandController{
    private RoleLogin roleLogin;
    private Role loginRole;

    public LoginCommandController() {
        this.roleLogin = new RoleLogin();
    }

    @Override
    public void getCommand(int command) {
        switch (command) {
            case 1: this.controlLogin();
                    break;
            case 2: System.out.println("退出成功！");
                    break;
            default: System.out.println("命令输入有误！");
        }
    }

    public void controlLogin() {
        this.loginRole = roleLogin.login();
        if (this.loginRole == null) {
            System.out.println("请重新输入用户名！");
            return;
        }
        if (loginRole instanceof User) {
            new UserView((User) loginRole).showView();
        } else if (loginRole instanceof Admin) {
            new AdminView((Admin) loginRole).showView();
        }
    }
}
