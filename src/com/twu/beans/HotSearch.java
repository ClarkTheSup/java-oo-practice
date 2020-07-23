package com.twu;

public abstract class HotSearch {
    private String name;
    private int voteNum;
    private boolean isBrought;
    private double boughtMoney;

    public HotSearch(String name) {
        this.name = name;
        this.voteNum = 0;
        this.isBrought = false;
        this.boughtMoney = 0;
    }

    @Override
    public String toString() {
        return name + " " + voteNum + " "
                + isBrought + " " + boughtMoney;
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

    public boolean isBrought() {
        return isBrought;
    }

    public void setBrought(boolean brought) {
        isBrought = brought;
    }

    public double getBoughtMoney() {
        return boughtMoney;
    }

    public void setBoughtMoney(double boughtMoney) {
        this.boughtMoney = boughtMoney;
    }
}
