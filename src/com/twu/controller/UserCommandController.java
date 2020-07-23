package com.twu;

public class UserCommandController extends CommandController {
    @Override
    public void getCommand(int command) {
        switch (command) {
            case 1: hotSearchBillboard.display();
                    break;
        }
    }
}
