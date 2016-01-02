package com.kalu.po.sum;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.kalu.po.sum.dataStructures.Bag;
import com.kalu.po.sum.dataStructures.Solution;

public class GreedySolver implements ISolver {

    public Solution solve(List<Integer> elements, int i) {
        Solution solution = new Solution(i);
        Queue<Bag> bags = new PriorityQueue<Bag>(solution.getAll());

        Collections.sort(elements);
        Collections.reverse(elements);
        for (Integer element : elements) {
            Bag min = bags.poll();
            min.addElement(element);
            bags.offer(min);
        }

        return solution;
    }

}
