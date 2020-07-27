package com.twu.view;

import com.twu.controller.CommandController;
import com.twu.controller.LoginCommandController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    private CommandController loginCommandController;


    public View(){this.loginCommandController = new LoginCommandController();}

    public void showView() {
        int command = -1; //初始化命令
        do {
            System.out.println("您可以进行的操作有：");
            System.out.println("1. 用户登录");
            System.out.println("2. 退出");
            System.out.print("请输入数字：");

            Scanner scanner = new Scanner(System.in);
            try {
                command = scanner.nextInt();
            } catch (InputMismatchException e) {
            }

            loginCommandController.getCommand(command);
        } while (command != 2);
    };
}
