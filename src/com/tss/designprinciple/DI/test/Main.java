package com.tss.designprinciple.DI.test;

import com.tss.designprinciple.DI.Logger;
import com.tss.designprinciple.DI.model.ProductionLogger;
import com.tss.designprinciple.DI.model.DBLogger;
import com.tss.designprinciple.DI.model.FileLogger;

public class Main {
    public static void main(String[] args) throws Exception {

        ProductionLogger logger =
                new ProductionLogger(new DBLogger(), new FileLogger());

        logger.log("Application started");
    }
}

