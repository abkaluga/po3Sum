package com.kalu.po.sum.dataStructures;

import java.util.LinkedList;
import java.util.List;

public class Bag implements Comparable<Bag> {

    private List<Integer> elements = new LinkedList<Integer>();
    private Long count = 0L;

    public void addElement(Integer element) {
        if (elements.add(element)) {
            count += element;
        }
    }

    public void removeElement(Integer element) {
        if (elements.remove(element)) {
            count -= element;
        }
    }

    public Long sum() {
        return count;
    }

    public void clear() {
        count = 0L;
        elements.clear();
    }

    public int compareTo(Bag otherBag) {
        return this.count.compareTo(otherBag.count);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(count);
        sb.append(" :");
        for (Integer i : elements) {
            sb.append(" " + i.toString());
        }
        return sb.toString();
    }

}
