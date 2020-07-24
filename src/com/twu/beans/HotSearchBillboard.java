package com.twu.beans;

import java.util.*;
import java.util.stream.Stream;

public class HotSearchBillboard {
    private List<HotSearch> hotSearchList; //存所有的热搜

    public HotSearchBillboard(List<HotSearch> hotSearchList) {
        this.hotSearchList = hotSearchList;
    }

    //如果有人购买热搜，先显示购买的热搜，再显示其他热搜
    public void display(){
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
        //查找名字匹配的热搜
        Optional<HotSearch> foundOptional = this.hotSearchList.stream().filter(
                hotSearch -> hotSearch.getName().toLowerCase().equals(((String) map.get("name")).toLowerCase())
        ).findFirst();
        if (foundOptional.isEmpty()) {
            System.out.println("输入的热搜不存在!"); //名字不匹配则抛出异常
            return;
        }

        //判断热搜类型并修改热搜票数
        HotSearch foundHotSearch = foundOptional.get();
        if (foundHotSearch instanceof PlainHotSearch) { //如果是普通热搜，票数直接相加
            foundHotSearch.setVoteNum(foundHotSearch.getVoteNum() + (int) map.get("voteNum"));
        } else if (foundHotSearch instanceof SuperHotSearch) { //超级热搜票数翻倍
            foundHotSearch.setVoteNum(foundHotSearch.getVoteNum() + ((int) map.get("voteNum") * 2));
        }
        this.sort();//投票后热搜排序
    }

    //购买热搜
    public void userPayForHotSearch(Map map) {
        String name = (String) map.get("name");
        double boughtMoney = (double) map.get("boughtMoney");
        int ranking = (int) map.get("ranking");

        //判断ranking输入是否合法
        if (ranking < 1 || ranking > this.hotSearchList.size()) {
            System.out.println("排名输入有误！");
            return;
        }

        //判断输入金额是否合法
        if (boughtMoney <= 0) {
            System.out.println("金额输入有误！");
            return;
        }

        HotSearch rankingHotSearch = this.hotSearchList.get(ranking-1); //在ranking对应位置的热搜
        HotSearch inputHotSearch = this.hotSearchList.stream().filter(
                hotSearch -> hotSearch.getName().toLowerCase().equals(name.toLowerCase())
        ).findFirst().get();

        if (inputHotSearch == null) {
            System.out.println("输入的热搜不存在");
            return;
        }

        //判断在ranking位置的热搜是否已购买，没购买则直接交换位置
        if (!rankingHotSearch.isBought()){
            inputHotSearch.setBought(true);
            inputHotSearch.setBoughtMoney(boughtMoney);
            Collections.swap(this.hotSearchList, ranking-1, this.hotSearchList.indexOf(inputHotSearch));
        } else {
            double currentBoughtMoney = inputHotSearch.getBoughtMoney() + boughtMoney;
            if (currentBoughtMoney > rankingHotSearch.getBoughtMoney()) {
                int oldInputHotSearchPosition = this.hotSearchList.indexOf(inputHotSearch); //记录没替换前热搜的位置
                inputHotSearch.setBought(true);
                inputHotSearch.setBoughtMoney(currentBoughtMoney);
                this.hotSearchList.set(ranking-1, inputHotSearch); //购买成功则替换热搜
                this.hotSearchList.remove(oldInputHotSearchPosition);//替换热搜后根据原始位置删除旧热搜
                System.out.println("热搜购买成功！");
            } else {
                System.out.println("金额不够，购买失败！");
            }
        }
        this.sort();//购买热搜后排序
    }

    //排序思路：固定购买热搜的位置，只变更没够买热搜的位置，按投票数排序
    public void sort() {
        //找出所有没有购买的热搜，记录其索引位置
        List<HotSearch> unBoughtHotSearchList = new ArrayList<HotSearch>();
        //找出没有购买的热搜
        for (HotSearch hotSearch : this.hotSearchList) {
            if (!hotSearch.isBought()) {
                unBoughtHotSearchList.add(hotSearch);
            }
        }
        unBoughtHotSearchList.sort(new SortedByVoteNumComparator());
        //排序后依次覆盖原列表中没购买的热搜
        int i = 0; //指向this.hotSearchList
        int j = 0; //指向unBoughtHotSearchList
        for (HotSearch hotSearch : this.hotSearchList) {
            if (!hotSearch.isBought()) {
                this.hotSearchList.set(i, unBoughtHotSearchList.get(j));
                j++;
            }
            i++;
        }
    }
}
