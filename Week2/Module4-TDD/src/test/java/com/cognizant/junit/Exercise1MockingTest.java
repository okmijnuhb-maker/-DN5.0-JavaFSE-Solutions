package com.cognizant.junit;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Exercise 1: Mocking and Stubbing
public class Exercise1MockingTest {

    @Test
    public void testExternalApi() {
        // Step 1: Create a mock object for ExternalApi
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Stub the method to return a predefined value
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 3: Use the mock in MyService and test
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Verify result
        assertEquals("Mock Data", result);
        System.out.println("Exercise 1 - Mocking and Stubbing passed!");
    }
}