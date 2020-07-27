package com.twu.controller;

import com.twu.beans.HotSearch;
import com.twu.role.Role;
import com.twu.role.User;

public class UserCommandController extends CommandController {
    private User role;
    public UserCommandController(User role) {
        this.role = role;
    }

    @Override
    public void getCommand(int command) {
        switch (command) {
            case 1: hotSearchBillboard.display();
                    break;
            case 2: hotSearchBillboard.addHotSearch(role.createPlainHotSearch());
                    break;
            case 3: hotSearchBillboard.vote(role.voteForHotSearch());
                    break;
            case 4: hotSearchBillboard.userPayForHotSearch(role.payForHotSearch());
                    break;
            case 5: System.out.println("退出成功！");
                    break;
            default: System.out.println("命令输入有误！");
        }
    }
}
