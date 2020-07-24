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
        System.out.print("Please input super hot search name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        return new SuperHotSearch(name);
    }
}
