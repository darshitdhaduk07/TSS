package com.tss.functionalinterface;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.function.Supplier;

public class SupplierClass {
    static Supplier<String> supplier = ()->{
         return String.valueOf(LocalDate.now());
    };

    static public Supplier<String> getSupplier()
    {
        return supplier;
    }

}
