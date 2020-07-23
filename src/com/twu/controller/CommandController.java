package com.twu;

public abstract class CommandController {
    protected HotSearchBillboard hotSearchBillboard;

    public CommandController() {
        this.hotSearchBillboard = HotSearchBillboardFactory.getInstance();
    }

    public abstract void getCommand(int command);
}
