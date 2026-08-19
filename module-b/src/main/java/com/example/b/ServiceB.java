package com.example.b;

import com.example.a.ServiceA;

public class ServiceB {

    private final ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public ServiceB() {
        this(new ServiceA());
    }

    public String getCombinedMessage() {
        return serviceA.getGreeting() + " -> Processed by Module B";
    }

    public int calculateDouble(int a, int b) {
        return serviceA.add(a, b) * 2;
    }
}
