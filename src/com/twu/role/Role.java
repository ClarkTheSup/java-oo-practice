package com.twu.role;

import com.twu.beans.HotSearch;
import com.twu.beans.PlainHotSearch;

import java.util.Scanner;

public abstract class Role {
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public HotSearch createPlainHotSearch() {
        System.out.print("请输入普通热搜名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        return new PlainHotSearch(name);
    };

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
