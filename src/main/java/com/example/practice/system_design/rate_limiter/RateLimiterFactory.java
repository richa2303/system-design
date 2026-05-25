package com.example.practice.system_design.rate_limiter;

public class RateLimiterFactory {

    RateLimiter rateLimiter(String type, int capacity, long windowSizeMillis) throws Exception{
        /*return switch (type){
            case "TOKEN_BUCKET" -> new TokenBucketRateLimiter(capacity, windowSizeMillis);
            case "LEAKY_BUCKET" -> new LeakyBucketRateLimiter(capacity, windowSizeMillis);
            default -> throw new IllegalArgumentException("Does not have this ratelimiter");
        };package

         */
        return new TokenBucketRateLimiter(12,31);
    }
}
