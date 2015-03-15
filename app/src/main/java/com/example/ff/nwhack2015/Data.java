package com.example.ff.nwhack2015;

import android.text.format.Time;

/**
 * Created by chris on 14/03/15.
 */
public class Data {
    private double totalDistance;
    private double lastTripDistance;
    private double longestTripDistance;
    private double bestEfficiency;
    private double averageEfficiency;
    private double lastEfficiency;

    private Time lastTimeChecked;

    private int numberOfTrips;

    public Data() {
        lastTimeChecked = new Time();
        lastTimeChecked.setJulianDay(Time.EPOCH_JULIAN_DAY);
    }

    public double getTotalDistance() {
        return this.totalDistance;
    }

    public double getLastTripDistance() {
        return this.lastTripDistance;
    }

    public double getLongestTripDistance() {
        return this.longestTripDistance;
    }

    public double getBestEfficiency() {
        return this.bestEfficiency;
    }

    public double getAverageEfficiency() {
        return this.averageEfficiency;
    }

    public double getLastEfficiency() {
        return this.lastEfficiency;
    }

    public Time getLastTimeChecked() {
        return this.lastTimeChecked;
    }

    public int getNumberOfTrips() {
        return this.numberOfTrips;
    }

    public void increaseTotalDistance(double distance) {
        this.totalDistance += distance;
    }

    public void setLastTripDistance(double distance) {
        this.lastTripDistance = distance;
    }

    public void setLongestTripDistance(double distance) {
        if (this.longestTripDistance < distance) {
            this.longestTripDistance = distance;
        }
    }

    public void setBestEfficiency(double efficiency) {
        if (this.bestEfficiency < efficiency) {
            this.bestEfficiency = efficiency;
        }
    }

    public void setAverageEfficiency(double efficiency) {
        this.averageEfficiency = ((this.averageEfficiency * this.numberOfTrips) + efficiency)
                / (this.numberOfTrips + 1);
    }

    public void setLastEfficiency(double efficiency) {
        this.lastEfficiency = efficiency;
    }

    public void increaseNumberOfTrips() {
        this.numberOfTrips++;
    }

    public void setLastTimeChecked(Time newTime) {
        this.lastTimeChecked = new Time(newTime);
    }

}
