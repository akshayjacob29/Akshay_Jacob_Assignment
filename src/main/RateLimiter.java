package main;

import api_reader.ApiRateLimit;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {
    private int limit;
    private long timeWindow;
    private Map<String, Map<String, RequestRate>> counters;
    private Map<String, ApiRateLimit> apiRequestRateMap;
    //private static Logger logger = Logger.getLogger("info");

    public RateLimiter(List<ApiRateLimit> limits) {

        apiRequestRateMap = new ConcurrentHashMap<>();
        counters = new ConcurrentHashMap<>();
        limits.stream().forEach(limit -> {
            apiRequestRateMap.put(limit.getApi(), limit);
        });
    }

    public boolean checkRequest(String user, String api) {

        long currentTime = System.currentTimeMillis();
        //logger.info("checkRequest Entered"+user+" "+api);
        var defaultRequestRate = new RequestRate(); // currentTime, 1
        if (counters.containsKey(user)) {
            if (counters.get(user).containsKey(api)) {
                long lastRequestTime = counters.get(user).get(api).getLastRequestedTime();
                if (currentTime - lastRequestTime < apiRequestRateMap.get(api).getTimeWindow()) {
                    if (counters.get(user).get(api).getCount() >= apiRequestRateMap.get(api).getLimit()) {
                        return false;
                    }
                    var requestRate = new RequestRate(counters.get(user).get(api).getCount() + 1, counters.get(user).get(api).getLastRequestedTime());
                    counters.get(user).put(api, requestRate); //when in the same time window but to increment the count
                } else {
                    counters.get(user).put(api, defaultRequestRate);//when the time window resets
                }
            } else {
                counters.get(user).put(api, defaultRequestRate);//for every new api for same user
            }
        } else {
            counters.put(user, new ConcurrentHashMap<>());//for every new user
            counters.get(user).put(api, defaultRequestRate);
        }
        return true;
    }

/*    public RequestRate getRate(String userId, String api) {
        return counters.get(userId).get(api);
    }*/
}


