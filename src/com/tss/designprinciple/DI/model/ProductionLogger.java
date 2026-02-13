package com.tss.designprinciple.DI.model;

import com.tss.designprinciple.DI.Logger;

public class ProductionLogger {

    private Logger primaryLogger;
    private Logger fallbackLogger;

    public ProductionLogger(DBLogger primaryLogger, FileLogger fallbackLogger) {
        this.primaryLogger = primaryLogger;
        this.fallbackLogger = fallbackLogger;
    }

    public void log(String message) throws Exception {
        try {
            primaryLogger.log(message);
        } catch (Exception e) {
            System.out.println("Primary logger failed: " + e.getMessage());
            fallbackLogger.log(message);
        }
    }
}

