package SDA.IntiveISSTracker;

import SDA.IntiveISSTracker.Model.DataPackage;
import SDA.IntiveISSTracker.Model.Position;

public class DataRepository extends Logic{
    private Double totalDistance;
    private double distance;
    private double speed;
    private long time;
    private long totalTime;

    public DataRepository() {
        this.totalDistance = 0D;
        this.distance = 0;
        this.speed = 0;
        this.time = 0;
        this.totalTime = 0;
    }

    DataPackage getDisplayableData(Position oldPosition, Position newPosition) {
        if (oldPosition.equals(null) || newPosition.equals(null))return new DataPackage();

        int secondsInHour = 3600;
        distance = getDistanceInKm(oldPosition, newPosition);
        totalDistance += distance;

        time = getTimeInSec(oldPosition, newPosition);
        totalTime += time;

        speed = getSpeedInKmH(oldPosition, newPosition);
        double averageSpeed = (totalDistance / totalTime) * secondsInHour;

        DataPackage data = new DataPackage();
        data.setAvarageSpeed(averageSpeed);
        data.setSpeed(speed);
        data.setDistance(distance);
        data.setTotalDistance(totalDistance);
        data.setTime(time);
        data.setTotalTime(totalTime);

        return data;
    }
}
