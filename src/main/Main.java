package main;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        RateLimiter rateLimiter = new RateLimiterFactory().createRateLimiter();
        for (int i = 0; i < 100; i++) {
            boolean requestAllowed = rateLimiter.checkRequest("user1", "/api/prod");
            //System.out.println("Rate of user1: " + rateLimiter.getRate("user1", "/api/prod").getCount() + " time: " + rateLimiter.getRate("user1", "/api/prod").getLastRequestedTime());
            if (requestAllowed) {
                System.out.println("Request Allowed");
            } else {
                System.out.println("Request Denied");
                Thread.sleep(1000);
            }
        }
    }
}
