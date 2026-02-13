package com.tss.designprinciple.DI.model;

import com.tss.designprinciple.DI.Logger;

public class DBLogger implements Logger {

    @Override
    public void log(String message) throws Exception {
        // Simulate DB logging
        System.out.println("Logging to Database: " + message);

        // Simulate DB failure
        throw new Exception("Database connection failed!");
    }
}

