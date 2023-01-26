package main;

public class RequestRate {
    private int count;
    private long lastRequestedTime;

    public RequestRate() {
        this.count = 1;
        this.lastRequestedTime = System.currentTimeMillis();
    }

    public RequestRate(int count, long lastRequestedTime) {
        this.count = count;
        this.lastRequestedTime = lastRequestedTime;
    }

    public int getCount() {
        return count;
    }

    public long getLastRequestedTime() {
        return lastRequestedTime;
    }

    public void incrementCount() {
        this.count++;
        this.lastRequestedTime = System.currentTimeMillis();
    }

    public void reset() {
        this.count = 0;
        this.lastRequestedTime = System.currentTimeMillis();
    }
}