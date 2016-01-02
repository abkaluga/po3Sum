package com.kalu.po.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.kalu.po.sum.dataStructures.Bag;
import com.kalu.po.sum.dataStructures.Solution;

public class SASolver implements ISolver {

    private static Random random = new Random();

    @Override
    public Solution solve(List<Integer> elements, int i) {
        final Solution solution = new Solution(i);
        Solution bestSolution;
        Integer[] balance = new Integer[i];
        final List<Integer> adviser = new ArrayList<Integer>();
        Long min, max, diff = Long.MAX_VALUE;
        int it = 0;

        Arrays.fill(balance, 5);
        prepareAdvise(i, balance, adviser);
        bestSolution = solution;
        Collections.sort(elements, Collections.reverseOrder());
        do {

            solution.getAll().parallelStream().forEach(Bag::clear);
            elements.parallelStream()//
                    .forEach((element) -> {
                        int index = Math.abs(random.nextInt(adviser.size()));
                        solution//
                                .get(adviser.get(index))//
                                .addElement(element);
                    });
            min = Collections.min(solution.getAll()).sum();
            max = Collections.max(solution.getAll()).sum();
            if (diff > (max - min)) {
                // System.err.printf("diff %d, %d-%d= %d\n", diff, max, min, max - min);
                diff = (max - min);
                it = 0;
                bestSolution = new Solution(solution);
            } else {

                ++it;
                if (it > 1 << 19) {
                    break;
                }
            }

        } while ((max - min) > 1);
        return bestSolution;
    }

    private void prepareAdvise(int i, Integer[] balance, final List<Integer> adviser) {
        adviser.clear();
        for (int f = 0; f < i; ++f) {
            for (int j = 0; j < balance[f]; ++j) {
                adviser.add(f);
            }
        }
    }

}
