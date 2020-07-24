package com.twu.controller;

import com.twu.beans.RoleLogin;
import com.twu.role.Role;

//对登录时的命令进行控制，不属于CommandController
public class LoginController{
    private RoleLogin roleLogin;

    public LoginController() {
        this.roleLogin = new RoleLogin();
    }

    public Role getLoginCommand(int command) {
        if (command == 1) {
            return roleLogin.login();
        } else {
            return null;
        }
    }
}
