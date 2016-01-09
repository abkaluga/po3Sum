package com.kalu.po.sum;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.kalu.po.sum.SASolverTest.SASolverNonRandomTest;
import com.kalu.po.sum.SASolverTest.SASolverSemiRandomTest;

@RunWith(Suite.class)
@SuiteClasses({ GreedySolverTest.class, KKSolverTest.class, SASolverNonRandomTest.class, SASolverSemiRandomTest.class })
public class AllTests {

}
