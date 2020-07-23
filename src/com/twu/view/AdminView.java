package com.twu;

import java.util.Scanner;

public class AdminView implements View{
    private CommandController commandController;

    public AdminView() {
        this.commandController = new AdminCommandController();
    }

    @Override
    public void showView() {
        System.out.println("1. 查看热搜排行榜");
        System.out.println("2. 添加热搜");
        System.out.println("3. 添加超级热搜");
        System.out.println("4. 退出");
        System.out.print("Please enter command number: ");

        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        commandController.getCommand(command);
    }
}
