package com.kalu.po.sum.dataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public enum SolutionState {
        unCount,
        Correct
    }
    List<Bag> bags;

    public Solution(int i) {
        List<Bag> protoBags = new ArrayList<Bag>(i);
        for (int j = 0; j < i; ++j) {
            protoBags.add(new Bag());
        }
        bags = Collections.unmodifiableList(protoBags);
    }

    public Bag get(int i) {
        return bags.get(i);
    }

    public List<Bag> getAll() {
        return bags;
    }

    public Long getDiff() {
        Bag min = Collections.min(bags), max = Collections.max(bags);
        return Math.abs(min.sum() - max.sum());
    }

}
