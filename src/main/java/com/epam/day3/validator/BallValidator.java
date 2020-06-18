package com.epam.day3.validator;

public class BallValidator {

    public boolean validateBallWeight(double weight) {
        double maxWeight = 500.0;
        double minWeight = 2.7;
        if (weight < minWeight || weight > maxWeight) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validateBallVolume(double volume) {
        double minVolume = 0.16;
        double maxVolume = 5.6;
        if (volume < minVolume || volume > maxVolume) {
            return false;
        } else {
            return true;
        }
    }
}
