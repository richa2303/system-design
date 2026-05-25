package com.example.practice.system_design.rate_limiter;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowLogRateLimiter implements RateLimiter{

    private final int maxRequest;
    private Map<String, Deque<Long>> requestLog = new ConcurrentHashMap<>();
    private final long windowSize ;

    public SlidingWindowLogRateLimiter(int maxRequest, long windowSize){
        this.maxRequest = maxRequest;
        this.windowSize = windowSize;
    }

    public boolean isRequestAllowed(String userId){
         long current = System.currentTimeMillis();
         requestLog.putIfAbsent(userId, new LinkedList<>());
         Deque<Long> timestamps = requestLog.get(userId);

         while(!timestamps.isEmpty()  && current-timestamps.peek() >= windowSize){
             timestamps.pollFirst();
         }
         if(timestamps.size() < maxRequest){
             timestamps.add(current);
             return true;
         }
         return false;
    }

}
