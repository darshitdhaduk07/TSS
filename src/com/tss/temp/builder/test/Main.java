package com.tss.temp.builder.test;

import com.tss.temp.builder.model.User;

public class Main {
    public static void main(String[] args) {
        User user = new User.Builder("Darshit")
                .age(20)
                .address("xyz")
                .email("abc@123")
                .build();

        System.out.println(user);
    }
}
