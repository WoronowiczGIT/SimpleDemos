package SDA.IntiveISSTracker.Model;

public class DataPackage {
    private double speed;
    private double avarageSpeed;
    private double distance;
    private double time;
    private double totalDistance;
    private double totalTime;

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setAvarageSpeed(double avarageSpeed) {
        this.avarageSpeed = avarageSpeed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public double getSpeed() {
        return speed;
    }

    public double getAvarageSpeed() {
        return avarageSpeed;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public double getTotalTime() {
        return totalTime;
    }
}
