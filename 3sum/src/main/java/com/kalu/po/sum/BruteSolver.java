package com.kalu.po.sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.kalu.po.sum.dataStructures.Solution;

public class BruteSolver implements ISolver {

    @Override
    public Solution solve(List<Integer> elements, int i) {
        List<Integer> copy = new LinkedList<>(elements);
        List<Solution> solutions = getAllSolutions(copy, i);
        return Collections.min(solutions);
    }

    public List<Solution> getAllSolutions(List<Integer> elements, int i) {
        if (elements.isEmpty()) {
            return Collections.singletonList(new Solution(i));
        } else {
            Integer el = elements.remove(0);
            List<Solution> newSolutions = new ArrayList<>(), //
                    oldSolutions = getAllSolutions(elements, i);
            for (Solution sol : oldSolutions) {
                for (int j = 0; j < i; ++j) {
                    Solution newSolution = new Solution(sol);
                    newSolution.getAll().get(j).addElement(el);
                    newSolutions.add(newSolution);
                }

            }
            return newSolutions;
        }
    }

}
