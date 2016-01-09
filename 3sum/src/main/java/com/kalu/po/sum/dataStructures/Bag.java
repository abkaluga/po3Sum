package com.kalu.po.sum.dataStructures;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class Bag implements Comparable<Bag> {

    protected Set<SANumber> elements;
    protected AtomicLong count;

    public Bag() {
        elements = new HashSet<SANumber>();
        count = new AtomicLong();
    }

    public void addElement(Integer element) {
        SANumber num = new SANumber(element.longValue());
        if (elements.add(num)) {
            count.getAndAdd(element);
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
        for (SANumber i : elements) {
            sb.append(" " + i.toString());
        }
        sb.append(']');
        return sb.toString();
    }

}
