package com.tss.designpattern.creationaldesignpattern.abstractfactory.test;

import com.tss.designpattern.creationaldesignpattern.abstractfactory.model.ICarFactory;
import com.tss.designpattern.creationaldesignpattern.abstractfactory.model.KIA;
import com.tss.designpattern.creationaldesignpattern.abstractfactory.model.KIAFactory;

public class Main {

    public static void main(String[] args) {

        ICarFactory iCarFactory = new KIAFactory();



    }
}