package com.tss.functionalinterface;

import java.util.function.Predicate;

public class PredicateClass {

    static Predicate<Integer> p = (a)->{
        return a % 2 != 0;
    };

    static public Predicate<Integer> getPredicate()
    {
        return p;
    }
}
