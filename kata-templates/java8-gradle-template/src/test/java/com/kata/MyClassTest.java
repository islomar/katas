package com.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MyClassTest {

    @Test public void testAppHasAGreeting() {
        MyClass classUnderTest = new MyClass();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}