package com.tss.functionalinterface;

import java.util.function.Consumer;

public class ConsumerClass {
    static Consumer<Integer> consumer = (a)->{
        System.out.println(a*a);
    };

    static public Consumer<Integer> getConsumer()
    {
        return consumer;
    }
}
