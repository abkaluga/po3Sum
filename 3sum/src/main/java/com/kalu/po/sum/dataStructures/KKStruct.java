package com.kalu.po.sum.dataStructures;

import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class KKStruct implements Comparable<KKStruct> {

    Long sum = 0L;
    private Long ts = System.nanoTime();
    NavigableSet<KKNumber> set = new TreeSet<KKNumber>(Collections.reverseOrder());

    public KKStruct() {
    };

    public KKStruct(int initValue, int size) {
        assert (size > 0);
        set.add(new KKNumber(initValue));
        sum = (long) initValue;
        while (set.size() != size)
            set.add(new KKNumber());

    }

    public Solution toSolution() {
        Solution sol = new Solution(set.size());
        Iterator<KKNumber> it = set.iterator();
        Iterator<Bag> listIt = sol.bags.iterator();
        while (it.hasNext() && listIt.hasNext()) {
            KKNumber nextNum = it.next();
            Bag nextBag = listIt.next();
            nextNum.represents.stream()//
                              .forEach((el) -> nextBag.addElement(el));
        }
        return sol;
    }

    public static KKStruct merge(KKStruct struct1, KKStruct struct2) {
        KKStruct result = new KKStruct();
        assert (struct1.set.size() == struct2.set.size());
        Iterator<KKNumber> it1 = struct1.set.iterator(), it2 = struct2.set.descendingIterator();

        while (it1.hasNext() && it2.hasNext()) {
            KKNumber mergedNum = KKNumber.merge(it1.next(), it2.next());
            result.set.add(mergedNum);
        }
        Integer smallest = result.set.last().actualValue;
        for (KKNumber num : result.set) {
            num.actualValue -= smallest;
            result.sum += num.actualValue;
        }

        return result;
    }

    @Override
    public int compareTo(KKStruct o) {
        int cmp = sum.compareTo(o.sum);
        return cmp == 0 ? ts.compareTo(o.ts) : cmp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        sb.append(sum);
        sb.append('}');
        sb.append('[');
        for (KKNumber i : this.set) {
            sb.append(i);
            sb.append(' ');
        }
        sb.append(']');
        return sb.toString();
    }

}
