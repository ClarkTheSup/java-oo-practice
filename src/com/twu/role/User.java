package com.twu.role;

import com.twu.role.Role;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User extends Role {
    private int heldVoteNum;
    public User(String name) {
        super(name);
        this.heldVoteNum = 10;
    }

    public Map voteForSearch() {
        Scanner scanner = new Scanner(System.in);
        Map map = new HashMap();
        System.out.print("name: ");
        String name = scanner.next();
        System.out.print("voteNum: ");
        int voteNum = scanner.nextInt();

        //判断票数是否充足
        if (voteNum > this.heldVoteNum) {
            System.out.println("Held vote number is not enough.");
            return map;
        }

        this.heldVoteNum = this.heldVoteNum - voteNum; //更新票数
        map.put("name", name);
        map.put("voteNum", voteNum);
        return map;
    }

}
