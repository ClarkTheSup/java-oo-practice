package com.twu.view;

import com.twu.controller.AdminCommandController;
import com.twu.controller.CommandController;
import com.twu.role.Admin;
import com.twu.role.Role;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminView extends View {
    private CommandController commandController;
    private Admin role;

    public AdminView(Admin role) {
        this.role = role;
        this.commandController = new AdminCommandController(role);
    }

    @Override
    public void showView() {
        System.out.println("欢迎！Admin用户：" + this.role.getName());

        int command = -1;
        do {
            System.out.println("1. 查看热搜排行榜");
            System.out.println("2. 添加热搜");
            System.out.println("3. 添加超级热搜");
            System.out.println("4. 退出");
            System.out.print("请输入数字：");

            Scanner scanner = new Scanner(System.in);
            try {
                command = scanner.nextInt();
            } catch (InputMismatchException e) {
            }

            commandController.getCommand(command);
        } while (command != 4);
    }
}
