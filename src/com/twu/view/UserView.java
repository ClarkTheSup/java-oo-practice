package com.twu.view;

import com.twu.controller.CommandController;
import com.twu.controller.UserCommandController;
import com.twu.role.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserView extends View {
    private CommandController commandController;
    private User role;

    public UserView(User role) {
        this.role = role;
        this.commandController = new UserCommandController(role);
    }

    @Override
    public void showView() {
        System.out.println("欢迎！User用户：" + this.role.getName());

        int command = -1;
        do {
            System.out.println("1. 查看热搜排行榜");
            System.out.println("2. 添加热搜");
            System.out.println("3. 给热搜事件投票");
            System.out.println("4. 购买热搜");
            System.out.println("5. 退出");
            System.out.print("请输入数字：");

            Scanner scanner = new Scanner(System.in);
            try {
                command = scanner.nextInt();
            } catch (InputMismatchException e) {
            }
            commandController.getCommand(command);
        } while (command != 5);
    }
}
