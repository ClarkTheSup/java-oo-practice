package com.twu.beans;

import java.util.ArrayList;

/*
生成单例的HotSearchBillboard
 */
public class HotSearchBillboardFactory {
    //饿汉式
    private static HotSearchBillboard hotSearchBillboard = new HotSearchBillboard(new ArrayList<HotSearch>());
    public static HotSearchBillboard getInstance() {
        return hotSearchBillboard;
    }
}
