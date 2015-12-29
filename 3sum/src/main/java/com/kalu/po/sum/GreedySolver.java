package com.kalu.po.sum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.kalu.po.sum.dataStructures.Bag;

public class GreedySolver implements ISolver {

    public Long solve(List<Integer> elements, Bag[] bags) {
        for (Bag bag : bags) {
            bag.clear();
        }
        List<Bag> lBags = Arrays.asList(bags);
        Collections.sort(elements);
        Collections.reverse(elements);
        for (Integer i : elements) {
            Bag min = Collections.min(lBags);
            min.addElement(i);
        }
        Bag min = Collections.min(lBags), max = Collections.max(lBags);
        Long diff = Math.abs(max.sum() - min.sum());

        return diff;
    }

}
