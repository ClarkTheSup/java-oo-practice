package com.twu.controller;

import com.twu.role.Admin;
import com.twu.role.Role;

public class AdminCommandController extends CommandController {
    private Admin role;
    public AdminCommandController(Admin role) {
        this.role = role;
    }

    @Override
    public void getCommand(int command) {
        switch (command) {
            case 1: hotSearchBillboard.display();
                    break;
            case 2: hotSearchBillboard.addHotSearch(role.createPlainHotSearch());
                    break;
            case 3: hotSearchBillboard.addHotSearch(role.createSuperHotSearch());
                    break;
            case 4: System.out.println("退出成功！");
                break;
            default: System.out.println("命令输入有误！");
        }
    }
}
