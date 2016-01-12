package com.kalu.po.sum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;

import com.kalu.po.sum.dataStructures.SANumber;
import com.kalu.po.sum.dataStructures.Solution;
import com.kalu.po.sum.dataStructures.SortedBag;

public class SASolver implements ISolver {

    public enum SA_MODE {
        FULL_RANDOM,
        SEMI_RANDOM,
        NON_RANDOM
    };

    private Random random = new Random(32);
    SortedSet<SANumber> set = new ConcurrentSkipListSet<SANumber>();
    SA_MODE mode;

    public SASolver(SA_MODE mode) {
        this.mode = mode;
    }

    @Override
    public Solution solve(List<Integer> elements, int i) {
        Collections.sort(elements, Collections.reverseOrder());

        SortedBag[] bags = new SortedBag[i];
        for (int j = 0; j < bags.length; ++j) {
            bags[j] = new SortedBag();
        }
        if (mode == SA_MODE.NON_RANDOM) {
            int it = 0;
            for (int el : elements) {
                bags[it].addElement(el);
                it = (it + 1) % i;

            }
        } else {
            elements.parallelStream()//
                    .forEach(//
                             (el) -> bags[random.nextInt(i)].addElement(el));
        }
        SortedBag min = null, max = null;
        long diff = Integer.MAX_VALUE;
        int life = 1000;
        if (mode == SA_MODE.SEMI_RANDOM || mode == SA_MODE.NON_RANDOM) {

            do {
                life--;
                min = Collections.min(Arrays.asList(bags));
                max = Collections.max(Arrays.asList(bags));
                throwPottato(min, max);
                min = Collections.min(Arrays.asList(bags));
                max = Collections.max(Arrays.asList(bags));
                if (diff < max.sum() - min.sum()) {
                    diff = max.sum() - min.sum();
                    life += 100;
                }
            } while (max.sum() - min.sum() != 0 && life > 0);
        } else {

            do {
                life--;
                int first = random.nextInt(bags.length), second;
                while ((second = random.nextInt(bags.length)) == first)
                    ;
                int cmp = bags[first].compareTo(bags[second]);
                if (cmp < 0) {
                    max = bags[second];
                    min = bags[first];
                } else {
                    max = bags[first];
                    min = bags[second];
                }
                throwPottato(min, max);
                min = Collections.min(Arrays.asList(bags));
                max = Collections.max(Arrays.asList(bags));
                if (diff < max.sum() - min.sum()) {
                    diff = max.sum() - min.sum();
                    life += incLife();
                }
            } while (max.sum() - min.sum() != 0 && life > 0);

        }
        Solution sol = new Solution(bags.length);
        sol.getAll().clear();
        sol.getAll().addAll(Arrays.asList(bags));
        return sol;
    }

    private int incLife() {
        int bound = 0;
        if (mode.equals(SA_MODE.NON_RANDOM)) {
            bound = 100 + random.nextInt(100);
        }
        if (mode.equals(SA_MODE.SEMI_RANDOM)) {
            bound = 1000 + random.nextInt(1000);
        }
        if (mode.equals(SA_MODE.FULL_RANDOM)) {
            bound = 100 + random.nextInt(100);
        }

        return bound;
    }

    private void throwPottato(SortedBag min, SortedBag max) {
        while (min.compareTo(max) < 0 || random.nextGaussian() > 0.7) {
            SANumber potato = max.getMin();
            max.removeElement(potato);
            min.addElement(potato);
        }
    }

}
