package com.tss.functionalinterface;

import java.util.function.BiFunction;

public class BiFunctionClass {
    static BiFunction<Integer,Integer,Integer> bf = (num1,num2)-> num1+num2;

    static public BiFunction<Integer,Integer,Integer> getBiFunction()
    {
        return bf;
    }
}
