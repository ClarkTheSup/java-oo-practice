package com.twu.view;

import com.twu.controller.CommandController;
import com.twu.controller.UserCommandController;
import com.twu.role.User;

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
        int command;
        do {
            System.out.println("1. 查看热搜排行榜");
            System.out.println("2. 添加热搜");
            System.out.println("3. 给热搜事件投票");
            System.out.println("4. 购买热搜");
            System.out.println("5. 退出");
            System.out.print("Please enter command number: ");

            Scanner scanner = new Scanner(System.in);
            command = scanner.nextInt();
            commandController.getCommand(command);
        } while (command != 5);
    }
}
