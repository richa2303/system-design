package com.example.practice.system_design.rate_limiter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowCounterRateLimiter implements RateLimiter{

    private final int maxRequest;
    private final long windowSize ;
    private final Map<String,Integer> requestCount = new ConcurrentHashMap<>();
    private long windowStart ;

    public FixedWindowCounterRateLimiter(int maxRequest, long windowSize){
        this.maxRequest = maxRequest;
        this.windowSize = windowSize;
        this.windowStart = System.currentTimeMillis();
    }

    public boolean isRequestAllowed(String userId){
        long currentTime = System.currentTimeMillis();
        if(currentTime-windowStart > windowSize){
            requestCount.remove(userId);
            windowStart = currentTime;
        }
        requestCount.put(userId, requestCount.getOrDefault(userId,0)+1);
        return requestCount.get(requestCount)>maxRequest;
    }

}
