package com.tss.designprinciple.DI.model;

import com.tss.designprinciple.DI.Logger;

public class FileLogger implements Logger {

    @Override
    public void log (String message)throws Exception {
        System.out.println("Logging to File: " + message);
    }
}
