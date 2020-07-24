package com.twu.controller;

import com.twu.beans.HotSearch;
import com.twu.beans.HotSearchBillboard;
import com.twu.beans.HotSearchBillboardFactory;
import com.twu.beans.PlainHotSearch;
import com.twu.role.Role;

import java.util.Scanner;

public abstract class CommandController {
    protected HotSearchBillboard hotSearchBillboard;

    public CommandController() {
        this.hotSearchBillboard = HotSearchBillboardFactory.getInstance();
    }

    public abstract void getCommand(int command);

}
