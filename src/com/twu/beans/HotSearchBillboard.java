package com.twu.beans;

import java.util.List;
import java.util.Map;

public class HotSearchBillboard {
    private List<HotSearch> hotSearchList;

    public HotSearchBillboard(List<HotSearch> hotSearchList) {
        this.hotSearchList = hotSearchList;
    }

    //显示每个热搜
    public void display(){
        this.hotSearchList.sort(new SortedByVoteNumComparator());
        System.out.println("--------------------------------------------------");
        System.out.println("| name | voteNum | isBrought | broughtMoney |");
        System.out.println("--------------------------------------------------");
        int i = 1;
        for (HotSearch hotSearch : hotSearchList) {
            System.out.print("| " + i++ + ". ");
            System.out.println(hotSearch);
        }
    }

    //添加热搜,普通热搜和超级热搜都用这个方法添加
    public void addHotSearch(HotSearch hotSearch) {
        if (!this.hotSearchList.stream().anyMatch(
                //不区分大小写
                h -> h.getName().toLowerCase().equals(hotSearch.getName().toLowerCase())
        )) {
            this.hotSearchList.add(hotSearch);
        } else {
            System.out.println("Add hot search failed! Duplicate hot search name.");
        }
    }

    //热搜投票
    public void vote (Map map) {
        this.hotSearchList.stream().forEach(
                hotSearch -> {
                    if (hotSearch.getName().equals(map.get("name"))) {
                        if (hotSearch instanceof PlainHotSearch) { //如果是普通热搜，票数直接相加
                            hotSearch.setVoteNum(hotSearch.getVoteNum() + (int) map.get("voteNum"));
                        } else if (hotSearch instanceof SuperHotSearch) { //超级热搜票数翻倍
                            hotSearch.setVoteNum(hotSearch.getVoteNum() + ((int) map.get("voteNum") * 2));
                        }
                    }
                }
        );
    }

}
