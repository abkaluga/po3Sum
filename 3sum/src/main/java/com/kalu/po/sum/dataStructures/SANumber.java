package com.kalu.po.sum.dataStructures;

import java.util.concurrent.atomic.AtomicLong;

public class SANumber extends Number implements Comparable<SANumber> {

    /**
     * 
     */
    private static final long serialVersionUID = -4572382328836361913L;

    Long num;

    Long diff;

    private static AtomicLong diffGen = new AtomicLong();

    public SANumber(Long num) {
        this.num = num;
        this.diff = diffGen.incrementAndGet();
    }

    @Override
    public int compareTo(SANumber arg0) {
        int cmp = num.compareTo(arg0.num);
        return cmp == 0 ? diff.compareTo(arg0.diff) : cmp;
    }

    @Override
    public String toString() {
        return num.toString();
    }

    @Override
    public double doubleValue() {
        return num.doubleValue();
    }

    @Override
    public float floatValue() {
        return num.floatValue();
    }

    @Override
    public int intValue() {
        return num.intValue();
    }

    @Override
    public long longValue() {
        return num.longValue();
    }

}
