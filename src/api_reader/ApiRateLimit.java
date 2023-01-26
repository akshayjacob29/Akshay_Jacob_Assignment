package api_reader;

public class ApiRateLimit {
    private String api;
    private int limit = 5;
    private long timeWindow = 1000;

    public ApiRateLimit(String api, int limit, long timeWindow) {
        this.api = api;
        this.limit = limit;
        this.timeWindow = timeWindow;
    }

    public ApiRateLimit(){

    }

    public String getApi() {
        return api;
    }

    public int getLimit() {
        return limit;
    }

    public long getTimeWindow() {
        return timeWindow;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setTimeWindow(long timeWindow) {
        this.timeWindow = timeWindow;
    }
}
