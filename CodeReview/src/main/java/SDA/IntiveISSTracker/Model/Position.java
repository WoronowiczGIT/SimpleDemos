package SDA.IntiveISSTracker;

public class Position {
    private long timeStamp;
    private double longitude;
    private double latitude;

    public Position(long timeStamp, double longitude, double latitude) {
        this.timeStamp = timeStamp;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
