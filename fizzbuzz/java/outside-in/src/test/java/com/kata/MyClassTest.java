package com.kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEmptyString.isEmptyString;

public class MyClassTest {

    @DisplayName("This is an example")
    @Test
    void blablabla() {
        assertThat("", isEmptyString());
    }
}