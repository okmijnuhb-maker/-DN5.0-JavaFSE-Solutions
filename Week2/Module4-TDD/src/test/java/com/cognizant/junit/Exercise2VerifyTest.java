package com.cognizant.junit;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

// Exercise 2: Verifying Interactions
public class Exercise2VerifyTest {

    @Test
    public void testVerifyInteraction() {
        // Step 1: Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Call the method
        MyService service = new MyService(mockApi);
        service.fetchData();

        // Step 3: Verify that getData() was called on the mock
        verify(mockApi).getData();

        System.out.println("Exercise 2 - Verifying Interactions passed!");
    }
}