package com.twu.view;

import com.twu.controller.LoginController;
import com.twu.role.Admin;
import com.twu.role.Role;
import com.twu.role.User;

import java.util.Scanner;

public class View {
    private LoginController loginController;
    private Role loginRole;

    public View(){this.loginController = new LoginController();}

    public void showView() {
        int command;
        do {
            System.out.println("1. 用户登录");
            System.out.println("2. 退出");
            System.out.print("Please enter command number: ");

            Scanner scanner = new Scanner(System.in);
            command = scanner.nextInt();
            loginRole = loginController.getLoginCommand(command);

            if (loginRole instanceof User) {
                new UserView((User) loginRole).showView();
            } else if (loginRole instanceof Admin) {
                new AdminView((Admin) loginRole).showView();
            } else {
                throw new RuntimeException("Role Type Exception.");
            }
        } while (command != 2);
    };
}
