package com.twu.role;

import com.twu.role.Role;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class User extends Role {
    private int heldVoteNum;
    public User(String name) {
        super(name);
        this.heldVoteNum = 10;
    }

    //投票
    public Map voteForHotSearch() {
        System.out.println("目前拥有的票数：" + this.getHeldVoteNum());
        Scanner scanner = new Scanner(System.in);
        Map map = new HashMap();
        System.out.print("热搜名: ");
        String name = scanner.next();
        System.out.print("票数: ");
        int voteNum = -1;
        try {
            voteNum = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("票数输入有误！");
            return map;
        }

        //判断票数是否充足
        if (voteNum > this.heldVoteNum) {
            System.out.println("票数不足！");
            return map;
        } else if (voteNum < 0) {
            System.out.println("票数输入有误！");
            return map;
        }

        map.put("User", this);
        map.put("name", name);
        map.put("voteNum", voteNum);
        return map;
    }

    //购买热搜
    public Map payForHotSearch() {
        Scanner scanner = new Scanner(System.in);
        Map map = new HashMap();
        System.out.print("热搜名: ");
        String name = scanner.next();
        double boughtMoney = 0;
        int ranking = 0;
        try {
            System.out.print("购买金额: ");
            boughtMoney = scanner.nextDouble();
            System.out.print("购买的排名: ");
            ranking = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("请输入正确的数字！");
            return map;
        }

        map.put("name", name);
        map.put("boughtMoney", boughtMoney);
        map.put("ranking", ranking);

        return map;
    }

    public int getHeldVoteNum() {
        return heldVoteNum;
    }

    public void setHeldVoteNum(int heldVoteNum) {
        this.heldVoteNum = heldVoteNum;
    }
}
