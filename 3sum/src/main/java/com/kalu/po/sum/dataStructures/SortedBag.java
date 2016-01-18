package com.kalu.po.sum.dataStructures;

import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicLong;

public class SortedBag extends Bag {

    private SortedSet<MyNumber> asSorted;

    public SortedBag() {

        this.asSorted = new ConcurrentSkipListSet<MyNumber>();
        this.elements = this.asSorted;
        count = new AtomicLong();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public MyNumber getMin() {
        return asSorted.first();
    }

    public MyNumber getMax() {
        return asSorted.last();
    }

    public void addElement(MyNumber element) {
        if (element != null && elements.add(element)) {
            count.getAndAdd(element.longValue());
        }
    }

    public void removeElement(MyNumber element) {
        if (element != null && elements.remove(element)) {
            count.getAndAdd((-1) * element.longValue());
        }
    }
}
