package com.tss.designprinciple.OCP.test;

import com.tss.designprinciple.OCP.model.FixedDeposit;
import com.tss.designprinciple.OCP.model.festivals.Divali;
import com.tss.designprinciple.OCP.model.festivals.Holi;
import com.tss.designprinciple.OCP.model.festivals.NewYear;

import java.util.ArrayList;
import java.util.List;

public class FixedDepositApp {
    public static void main(String[] args) {
        List<FixedDeposit> fdList = new ArrayList<>();

        fdList.add(new FixedDeposit(101L, 2, new Divali(), 100000));
        fdList.add(new FixedDeposit(102L, 3, new Holi(), 150000));
        fdList.add(new FixedDeposit(103L, 1, new NewYear(), 200000));

        for(FixedDeposit fd : fdList)
        {
            fd.getDetails();
        }
    }

}

