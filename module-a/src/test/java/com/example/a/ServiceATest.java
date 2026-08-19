package com.example.a;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ServiceATest {

    @Test
    void testGetGreeting() {
        ServiceA serviceA = new ServiceA();
        assertNotNull(serviceA.getGreeting());
        assertEquals("Hello from Module A", serviceA.getGreeting());
    }

    @Test
    void testAdd() {
        ServiceA serviceA = new ServiceA();
        assertEquals(5, serviceA.add(2, 3));
    }
}
