package com.example.b;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ServiceBTest {

    @Test
    void testGetCombinedMessage() {
        ServiceB serviceB = new ServiceB();
        assertNotNull(serviceB.getCombinedMessage());
        assertEquals("Hello from Module A -> Processed by Module B", serviceB.getCombinedMessage());
    }

    @Test
    void testCalculateDouble() {
        ServiceB serviceB = new ServiceB();
        assertEquals(10, serviceB.calculateDouble(2, 3));
    }
}
