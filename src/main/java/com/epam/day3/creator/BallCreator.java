package com.epam.day3.creator;

import com.epam.day3.entity.Ball;
import com.epam.day3.entity.Color;
import com.epam.day3.validator.BallValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BallCreator {

    public List<Ball> createBallsList() {
        BallValidator validator = new BallValidator();
        Random random = new Random();
        List<Ball> balls = new ArrayList<>();
        Color[] colors = {Color.BLUE, Color.BLACK, Color.RED, Color.WHITE, Color.YELLOW};
        for (int i = 0; i < 10; i++) {
            int nextColor = random.nextInt(colors.length);
            Ball ball = new Ball((Math.random() * 1000), Math.random() * 10, colors[nextColor]);
            if (validator.validateBallWeight(ball.getWeight())
                    && validator.validateBallVolume(ball.getVolume())) {
                balls.add(ball);
            }
        }
        return balls;
    }
}
