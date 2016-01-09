package com.kalu.po.sum.dataStructures;

import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicLong;

public class SortedBag extends Bag {

    public SortedBag() {
        this.elements = new ConcurrentSkipListSet<SANumber>();
        count = new AtomicLong();
    }

    public SANumber getMin() {
        if (elements.isEmpty()) {
            return null;
        }
        return ((SortedSet<SANumber>) elements).first();
    }

    public SANumber getMax() {
        if (elements.isEmpty()) {
            return null;
        }
        return ((SortedSet<SANumber>) elements).last();
    }

    public void addElement(SANumber element) {
        if (element != null && elements.add(element)) {
            count.getAndAdd(element.longValue());
        }
    }

    public void removeElement(SANumber element) {
        if (element != null && elements.remove(element)) {
            count.getAndAdd((-1) * element.longValue());
        }
    }
}
