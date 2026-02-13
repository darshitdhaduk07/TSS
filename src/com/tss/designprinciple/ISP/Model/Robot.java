package com.tss.designprinciple.ISP.Model;

import com.tss.designprinciple.ISP.IRobot;

public class Robot implements IRobot {
    @Override
    public void charge() {
        System.out.println("Robot on Charge");
    }

    @Override
    public void doWork() {
        System.out.println("Robot Working");
    }
}
