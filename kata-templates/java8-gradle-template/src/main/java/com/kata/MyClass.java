package com.kata;

public class MyClass {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new MyClass().getGreeting());
    }
}