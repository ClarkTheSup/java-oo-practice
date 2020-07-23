package com.twu;
/*
生成单例的HotSearchBillboard
 */
public class HotSearchBillboardFactory {
    //饿汉式
    private static HotSearchBillboard hotSearchBillboard = new HotSearchBillboard();
    public static HotSearchBillboard getInstance() {
        return hotSearchBillboard;
    }
}
