package com.tss.designprinciple.ISP.test;

import com.tss.designprinciple.ISP.Model.Human;
import com.tss.designprinciple.ISP.Model.Robot;

public class App {
    public static void main(String[] args) {
        Robot robot = new Robot();
        Human human = new Human();

        robot.charge();
        robot.doWork();

        human.eat();
        human.doWork();
        human.rest();

    }
}
