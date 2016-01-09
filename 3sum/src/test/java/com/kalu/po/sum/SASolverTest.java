package com.kalu.po.sum;

import org.junit.BeforeClass;

import com.kalu.po.sum.SASolver.SA_MODE;

public abstract class SASolverTest {

    public static class SASolverNonRandomTest extends ISolverTest {

        @BeforeClass
        public static void setUp() {
            objectOfTest = new SASolver(SA_MODE.NON_RANDOM);
        }
    }

    public static class SASolverSemiRandomTest extends ISolverTest {

        @BeforeClass
        public static void setUp() {
            objectOfTest = new SASolver(SA_MODE.SEMI_RANDOM);
        }
    }
}
