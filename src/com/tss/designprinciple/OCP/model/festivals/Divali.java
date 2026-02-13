package com.tss.designprinciple.OCP.model.festivals;

import com.tss.designprinciple.OCP.model.FestivalTyep;

public class Divali implements FestivalTyep {
    int rate = 10;

    @Override
    public int getRate() {
        return rate;
    }
    @Override
    public String toString() {
        return "Divali";
    }
}
