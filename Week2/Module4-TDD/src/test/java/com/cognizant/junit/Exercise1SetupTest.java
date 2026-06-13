package com.cognizant.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Exercise 1: Setting Up JUnit
// This test verifies that JUnit is set up correctly in the project
public class Exercise1SetupTest {

    @Test
    public void testSetup() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
        System.out.println("JUnit setup successful! Test executed.");
    }
}