package com.kalu.po.sum;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.kalu.po.sum.dataStructures.KKStruct;
import com.kalu.po.sum.dataStructures.Solution;

public class KKSolver implements ISolver {

    @Override
    public Solution solve(List<Integer> elements, int i) {
        Queue<KKStruct> set = new PriorityQueue<KKStruct>(Collections.reverseOrder());

        for (Integer el : elements) {
            set.add(new KKStruct(el, i));
        }

        while (set.size() > 1) {
            KKStruct struct1 = set.poll(), struct2 = set.poll();
            set.add(KKStruct.merge(struct1, struct2));
        }

        Solution sol = set.poll().toSolution();

        return sol;
    }

}
