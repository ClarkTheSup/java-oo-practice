package com.twu;

import java.util.Comparator;

public class SortedByVoteNumComparator implements Comparator<HotSearch> {
    @Override
    public int compare(HotSearch o1, HotSearch o2) {
        if (o1.getVoteNum() > o2.getVoteNum()) {
            return 1;
        } else if (o1.getVoteNum() < o2.getVoteNum()) {
            return -1;
        } else {
            return 0;
        }
    }
}
