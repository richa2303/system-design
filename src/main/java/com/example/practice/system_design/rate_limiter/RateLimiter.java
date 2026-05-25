package com.example.practice.system_design.rate_limiter;

public interface RateLimiter {

    public boolean isRequestAllowed(String userId);

}
