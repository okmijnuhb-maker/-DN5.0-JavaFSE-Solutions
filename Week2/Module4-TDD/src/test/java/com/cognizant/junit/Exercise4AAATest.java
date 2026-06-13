package com.cognizant.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise4AAATest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: Calculator instance created");
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Calculator instance destroyed");
    }

    @Test
    public void testAddition() {
        int a = 10;
        int b = 5;

        int result = calculator.add(a, b);

        assertEquals(15, result);
    }

    @Test
    public void testSubtraction() {
        int a = 10;
        int b = 5;

        int result = calculator.subtract(a, b);

        assertEquals(5, result);
    }
}