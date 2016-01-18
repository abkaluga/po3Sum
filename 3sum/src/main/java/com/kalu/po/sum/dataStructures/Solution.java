package com.kalu.po.sum.dataStructures;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution implements Comparable<Solution> {
    List<Bag> bags;

    public Solution(int i) {
        bags = new LinkedList<Bag>();
        for (int j = 0; j < i; ++j) {
            bags.add(new Bag());
        }

    }

    public Solution(Solution s) {
        bags = new LinkedList<Bag>();
        for (Bag b : s.bags) {
            bags.add(new Bag(b));
        }
    }

    public Solution(List<Bag> bags) {
        this.bags = new LinkedList<>();
        for (Bag b : bags) {
            bags.add(new Bag(b));
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

    @Override
    public int compareTo(Solution arg0) {
        int odp = getDiff().compareTo(arg0.getDiff());
        return getDiff().compareTo(arg0.getDiff());
    }

}
