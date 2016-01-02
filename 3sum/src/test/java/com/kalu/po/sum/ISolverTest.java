package com.kalu.po.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.kalu.po.sum.dataStructures.Solution;

import junit.framework.Assert;

public abstract class ISolverTest {

    private static final int SIZE = 3;
    protected static ISolver objectOfTest;
    private static Integer[] dummyList;
    private static Integer[] tripleSmall;
    private static Integer[] tripleBig;
    private static Integer[] onlyOnes;
    private static Integer[] onlyOnesRem;
    private static Integer[] antiGreedy = { 8, 5, 4, 4, 3, 2, 1 };

    static {
        dummyList = new Integer[3];
        onlyOnes = new Integer[9999];
        onlyOnesRem = new Integer[1000];
        tripleSmall = new Integer[24];
        tripleBig = new Integer[999999];
        Random rand = new Random(42);
        for (int i = 0; i < tripleSmall.length; i += 3) {
            int num = Math.abs(rand.nextInt(1000));
            tripleSmall[i + 0] = num;
            tripleSmall[i + 1] = num;
            tripleSmall[i + 2] = num;
        }
        rand.setSeed(42);
        for (int i = 0; i < tripleBig.length; i += 3)

        {
            int num = Math.abs(rand.nextInt(100));
            tripleBig[i + 0] = num;
            tripleBig[i + 1] = num;
            tripleBig[i + 2] = num;
        }

        Arrays.fill(onlyOnesRem, 1);
        Arrays.fill(onlyOnes, 1);
        Arrays.fill(dummyList, 5);

    }

    @Test
    public void antiGreedy() {
        // Setup
        Solution solution;
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(antiGreedy));
        Collections.shuffle(list);
        // Test
        solution = objectOfTest.solve(list, SIZE);
        // Assert
        Assert.assertEquals(Long.valueOf(0), solution.getDiff());
    }

    @Test
    public void tripleBigTest() {
        // Setup
        Solution solution;
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(tripleBig));
        Collections.shuffle(list);
        // Test
        solution = objectOfTest.solve(list, SIZE);
        // Assert
        Assert.assertEquals(Long.valueOf(0), solution.getDiff());
    }

    @Test
    public void tripleSmallTest() {
        // Setup
        Solution solution;
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(tripleSmall));
        Collections.shuffle(list);
        // Test
        solution = objectOfTest.solve(list, SIZE);
        // Assert
        Assert.assertEquals(Long.valueOf(0), solution.getDiff());
    }

    @Test
    public void onlyOnesRemTest() {
        // Setup
        Solution solution;
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(onlyOnesRem));
        Collections.shuffle(list);
        // Test
        solution = objectOfTest.solve(list, SIZE);
        // Assert
        Assert.assertEquals(Long.valueOf(1), solution.getDiff());
    }

    @Test
    public void onlyOnesTest() {
        // Setup
        Solution solution;
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(onlyOnes));
        Collections.shuffle(list);
        // Test
        solution = objectOfTest.solve(list, SIZE);
        // Assert
        Assert.assertEquals(Long.valueOf(0), solution.getDiff());
    }

    @Test
    public void dummyTest() {
        // Setup
        Solution solution;
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(dummyList));
        Collections.shuffle(list);
        // Test
        solution = objectOfTest.solve(list, SIZE);
        // Assert
        Assert.assertEquals(Long.valueOf(0), solution.getDiff());
    }

}
