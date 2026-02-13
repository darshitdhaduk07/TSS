package com.tss.designprinciple.ISP.Model;

import com.tss.designprinciple.ISP.IHuman;

public class Human implements IHuman {
    @Override
    public void doWork() {
        System.out.println("Human  Working");
    }

    @Override
    public void eat() {
        System.out.println("Human Eating");
    }

    @Override
    public void rest() {
        System.out.println("Human on Rest");
    }
}
