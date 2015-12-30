package com.kalu.po.sum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.kalu.po.sum.dataStructures.Bag;
import com.kalu.po.sum.dataStructures.Solution;

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

    public Solution solve(List<Integer> elements, int i) {
        Solution solution = new Solution(i);

        Collections.sort(elements);
        Collections.reverse(elements);
        for (Integer element : elements) {
            Bag min = Collections.min(solution.getAll());
            min.addElement(element);
        }

        return solution;
    }

}
