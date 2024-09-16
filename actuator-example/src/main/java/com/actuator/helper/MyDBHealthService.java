package com.actuator.helper;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Controller
public class MyDBHealthService implements HealthIndicator {

    public boolean isHealthGood()
    {
        return false;
    }
    @Override
    public Health health() {
        if (isHealthGood())
        {
            return Health.up().withDetail("Database Service","Database service is running..").build();
        }

        return Health.down().withDetail("Database Service","Database Service is down ").build();
    }
}
