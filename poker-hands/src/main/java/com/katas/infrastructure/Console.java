package com.katas.infrastructure;

public class Console implements OutputWriter {

    public void write(String message) {
        System.out.println(message);
    }
}
