package com.tss.collections.librarymanagement.module;

public class Member {
    private int id;
    private static int counter = 0;
    private String name;
    private String email;

    public Member(String name, String email) {
        this.id = ++counter;
        this.name = name;
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return String.format(
                "%-5d %-20s %-30s",
                id,
                name,
                email
        );
    }
}
