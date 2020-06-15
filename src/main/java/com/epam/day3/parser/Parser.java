package com.epam.day3.parser;

import com.epam.day3.entity.Ball;
import com.epam.day3.entity.Color;
import com.epam.day3.exception.CustomException;

public class Parser {

    private final String REGEX = " ";

    public Ball parseToBall(String s) throws CustomException {
        Ball ball = new Ball();
        String[] values = s.split(REGEX);
        try {
            int weight = Integer.parseInt(values[0]);
            ball.setWeight(weight);
            double volume = Double.parseDouble(values[1]);
            ball.setVolume(volume);
            for (Color tmp : Color.values()) {
                if (tmp.toString().equals(values[2].toUpperCase())) {
                    ball.setColor(tmp);
                }
            }
        } catch (NumberFormatException e) {
            throw new CustomException("Incorrect input data", e);
        }
        return ball;
    }
}
