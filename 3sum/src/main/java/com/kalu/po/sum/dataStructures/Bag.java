package com.kalu.po.sum.dataStructures;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Bag implements Comparable<Bag> {

    private List<Integer> elements = Collections.synchronizedList(new LinkedList<Integer>());
    private AtomicLong count = new AtomicLong();

    public void addElement(Integer element) {
        if (elements.add(element)) {
            count.getAndAdd(element);
        }
    }

    public void removeElement(Integer element) {
        if (elements.remove(element)) {
            count.getAndAdd(-element);
        }
    }

    public Long sum() {
        return count.get();
    }

    public void clear() {
        count.set(0);
        elements.clear();
    }

    @Override
    public int compareTo(Bag otherBag) {
        Long thisCount = count.get();
        return thisCount.compareTo(otherBag.sum());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(count.get());
        sb.append(" :[");
        for (Integer i : elements) {
            sb.append(" " + i.toString());
        }
        sb.append(']');
        return sb.toString();
    }

}
