package tests;

import api_reader.ApiRateLimit;
import main.RateLimiter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestRateLimiter {

    @Test
    public void testCheckRequestWithinRateLimit() throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(List.of(new ApiRateLimit("/api/prod", 10, 1)));
        for (int i = 0; i < 10; i++) {
            boolean requestAllowed = rateLimiter.checkRequest("user1", "/api/prod");
            assertTrue(requestAllowed);
        }
        boolean requestAllowed = rateLimiter.checkRequest("user1", "/api/prod");
        assertTrue(!requestAllowed);
    }

    @Test
    public void testCheckRequestOverRateLimit() throws InterruptedException {
        List<ApiRateLimit> limits = new ArrayList<>();
        limits.add(new ApiRateLimit("/api/prod", 10, 60000));
        RateLimiter rateLimiter = new RateLimiter(limits);
        for (int i = 0; i < 11; i++) {
            boolean requestAllowed = rateLimiter.checkRequest("user1", "/api/prod");
            if (i == 10) {
                assertTrue(!requestAllowed);
            } else {
                assertTrue(requestAllowed);
            }
        }
    }

    @Test
    public void testCheckRequestExceedingRateLimit() {
        RateLimiter rateLimiter = new RateLimiter(List.of(new ApiRateLimit("/api/prod", 10, 1000)));
        for (int i = 0; i < 10; i++) {
            boolean requestAllowed = rateLimiter.checkRequest("user1", "/api/prod");
            assertTrue(requestAllowed);
        }
        boolean requestAllowed = rateLimiter.checkRequest("user1", "/api/prod");
        assertTrue(!requestAllowed);
    }
}
