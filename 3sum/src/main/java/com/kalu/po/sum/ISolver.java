package com.kalu.po.sum;

import java.util.List;

import com.kalu.po.sum.dataStructures.Bag;

public interface ISolver {

    public Long solve(List<Integer> elements, Bag[] bags);
}
