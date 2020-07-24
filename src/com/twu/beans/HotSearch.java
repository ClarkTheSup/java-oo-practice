package com.twu.beans;

public abstract class HotSearch {
    private String name;
    private int voteNum;
    private boolean isBought;
    private double boughtMoney;
    private int ranking;

    public HotSearch(String name) {
        this.name = name;
        this.voteNum = 0;
        this.isBought = false;
        this.boughtMoney = 0;
        this.ranking = Integer.MAX_VALUE; //无限大，越大排名越靠后
    }

    @Override
    public String toString() {
        return name + " | " + voteNum + " | "
                + isBought + " | " + boughtMoney + " |";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(int voteNum) {
        this.voteNum = voteNum;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean brought) {
        isBought = brought;
    }

    public double getBoughtMoney() {
        return boughtMoney;
    }

    public void setBoughtMoney(double boughtMoney) {
        this.boughtMoney = boughtMoney;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
