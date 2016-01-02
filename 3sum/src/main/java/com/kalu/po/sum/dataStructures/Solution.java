package com.kalu.po.sum.dataStructures;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Solution {
    List<Bag> bags;

    public Solution(int i) {
        bags = new CopyOnWriteArrayList<Bag>();
        for (int j = 0; j < i; ++j) {
            bags.add(new Bag());
        }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (Bag bag : bags) {
            sb.append(bag.sum());
            sb.append(',');
        }

        sb.append(']');

        return sb.toString();
    }

}
