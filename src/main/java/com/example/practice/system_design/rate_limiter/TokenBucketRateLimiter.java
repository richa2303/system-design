package com.example.practice.system_design.rate_limiter;

import java.sql.Time;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter implements RateLimiter{

    private final int capacity;
    private final double refillRate;
    private final Map<String,Integer> tokens = new ConcurrentHashMap<>();
    private final Map<String, Long> lastRefillTimestamp = new ConcurrentHashMap<>();

    TokenBucketRateLimiter(int capacity, double refillRate){
        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    @Override
    public boolean isRequestAllowed(String userId){
        long currentTime = System.currentTimeMillis();
        lastRefillTimestamp.putIfAbsent(userId, currentTime);
        tokens.putIfAbsent(userId, capacity);
        long lastRefill = lastRefillTimestamp.get(userId);
        long elapsedTime = (currentTime - lastRefill) / 1000;
        if(elapsedTime > 0){
            int newToken = Math.min(capacity, tokens.get(userId) + (int)(refillRate * elapsedTime));
            tokens.put(userId, newToken);
            lastRefillTimestamp.put(userId, currentTime);
        }
        if(tokens.get(userId)>0){
            tokens.put(userId, tokens.get(userId)-1);
            return true;
        }
        return false;
    }

}
