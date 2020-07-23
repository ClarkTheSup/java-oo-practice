package com.twu;

import java.util.Scanner;

public class UserView implements View{
    private CommandController commandController;

    public UserView() {
        this.commandController = new UserCommandController();
    }

    @Override
    public void showView() {
        System.out.println("1. 查看热搜排行榜");
        System.out.println("2. 添加热搜");
        System.out.println("3. 给热搜事件投票");
        System.out.println("4. 购买热搜");
        System.out.println("5. 退出");
        System.out.print("Please enter command number: ");

        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        commandController.getCommand(command);
    }
}
