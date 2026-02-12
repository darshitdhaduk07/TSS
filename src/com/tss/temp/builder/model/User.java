package com.tss.temp.builder.model;

public class User {
    private String name;
    private int age;
    private String email;
    private String address;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.address = builder.address;
    }
    public static class Builder {

        private String name;
        private int age;
        private String email;
        private String address;

        public Builder(String name) {   // required field
            this.name = name;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
    public String toString()
    {
        return "User ["+"name="+name+", age="+age+", email="+email+", address="+address+"]";
    }

}
