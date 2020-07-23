package com.twu;

import java.util.List;

public class HotSearchBillboard {
    private List<HotSearch> hotSearchList;

    public void display(){
        hotSearchList.add(new PlainHotSearch("jack"));
        this.hotSearchList.sort(new SortedByVoteNumComparator());
        hotSearchList.stream().forEach(
                hotSearch -> {System.out.println(hotSearch);}
        );
    }
}
