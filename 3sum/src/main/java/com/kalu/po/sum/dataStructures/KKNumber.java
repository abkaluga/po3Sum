package com.kalu.po.sum.dataStructures;

import java.util.LinkedList;
import java.util.List;

public class KKNumber implements Comparable<KKNumber> {
    List<Integer> represents;
    protected Integer actualValue;
    private Long ts = System.nanoTime();

    public KKNumber() {
        represents = new LinkedList<Integer>();
        actualValue = 0;
    };

    public KKNumber(int init) {
        represents = new LinkedList<Integer>();
        represents.add(init);
        actualValue = init;
    }

    public static KKNumber merge(KKNumber num1, KKNumber num2) {
        KKNumber result = new KKNumber(num1.actualValue + num2.actualValue);
        result.represents.clear();
        result.represents.addAll(num1.represents);
        result.represents.addAll(num2.represents);

        return result;
    }

    public void normalize(Integer sub) {
        actualValue -= sub;
    }

    @Override
    public int compareTo(KKNumber o) {
        int cmp = actualValue.compareTo(o.actualValue);
        return cmp == 0 ? ts.compareTo(o.ts) : cmp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        sb.append(actualValue);
        sb.append('}');
        for (Integer i : this.represents) {
            sb.append(i);
            sb.append(' ');
        }
        return sb.toString();
    }

}
