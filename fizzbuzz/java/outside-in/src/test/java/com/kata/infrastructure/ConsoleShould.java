package com.kata.infrastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.fail;

public class ConsoleShould {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final String MESSAGE = "Hello world";

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void write_to_system_out_println() {

        Console console = new Console();

        console.print(MESSAGE);

        assertThat(outContent.toString(), is(MESSAGE + "\n"));
    }
}