package com.twu.role;

import com.twu.beans.HotSearch;
import com.twu.beans.PlainHotSearch;
import com.twu.beans.SuperHotSearch;
import com.twu.role.Role;

import java.util.Scanner;

public class Admin extends Role {
    public Admin(String name) {
        super(name);
    }
    public HotSearch createSuperHotSearch() {
        System.out.print("请输入超级热搜名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        return new SuperHotSearch(name);
    }
}
