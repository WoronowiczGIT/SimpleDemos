package SDA.IntiveISSTracker;

import SDA.IntiveISSTracker.Model.Position;

public class Logic {

    public static double getSpeed(Position oldPosition, Position newPosition) {
        long oldTime = oldPosition.getTimeStamp();
        long newTime = newPosition.getTimeStamp();

        long timeInSeconds =  (newTime - oldTime);
        Double distanceInKm = getDistance(oldPosition,newPosition);

        Double velocity = distanceInKm/timeInSeconds;
        return velocity*3600;
    }

   static public Double getDistance(Position oldPosition, Position newPosition){
        double oldLatitude = oldPosition.getLatitude();
        double oldLongitude = oldPosition.getLongitude();
        double newLatitude = newPosition.getLatitude();
        double newLongitude = newPosition.getLongitude();

        Double distance = calculateDistance(oldLatitude,oldLongitude,newLatitude,newLongitude);
        return distance;
    }

   private static double calculateDistance(double lat1, double long1, double lat2, double long2) {
        double earthRadius = 6371;
        double distance = Math.acos(Math.sin(lat2 * Math.PI / 180.0) * Math.sin(lat1 * Math.PI / 180.0) +
                Math.cos(lat2 * Math.PI / 180.0) * Math.cos(lat1 * Math.PI / 180.0) *
                        Math.cos((long1 - long2) * Math.PI / 180.0)) * earthRadius;
        return distance;
    }
}
