package SDA.IntiveISSTracker;

import SDA.IntiveISSTracker.Model.Position;

abstract class GeographicalCalculator {
    private static final int secondsInHour = 3600;
    private static final int earthRadius = 6371;
    private static final double radian = 180 / Math.PI;

    long getTimeInSec(Position oldPosition, Position newPosition) {
        return newPosition.getTimeStamp() - oldPosition.getTimeStamp();
    }

    double getSpeedInKmH(Position oldPosition, Position newPosition) {

        long timeInSeconds = getTimeInSec(oldPosition, newPosition);
        double distanceInKm = getDistanceInKm(oldPosition, newPosition);

        double velocityKmS = distanceInKm / timeInSeconds;
        return velocityKmS * secondsInHour;
    }

    Double getDistanceInKm(Position oldPosition, Position newPosition) {
        double oldLatitude = oldPosition.getLatitude();
        double oldLongitude = oldPosition.getLongitude();
        double newLatitude = newPosition.getLatitude();
        double newLongitude = newPosition.getLongitude();

        Double distance = calculateDistance(oldLatitude, oldLongitude, newLatitude, newLongitude);
        return distance;
    }

    private static double calculateDistance(double lat1, double long1, double lat2, double long2) {

        double distance = Math.acos(Math.sin(lat2 / radian) * Math.sin(lat1 / radian) +
                Math.cos(lat2 / radian) * Math.cos(lat1 / radian) *
                        Math.cos((long1 - long2) / radian)) * earthRadius;
        return distance;
    }
}
