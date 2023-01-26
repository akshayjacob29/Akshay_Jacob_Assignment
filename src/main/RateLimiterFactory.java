package main;

import api_reader.RateLimiterReader;

import java.io.IOException;

public class RateLimiterFactory {

    public RateLimiterFactory() {
    }

    public RateLimiter createRateLimiter() throws IOException {
        var reader = new RateLimiterReader();
        return new RateLimiter(reader.getRateLimits());
    }
}