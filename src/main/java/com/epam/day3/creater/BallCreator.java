package com.epam.day3.creater;

import com.epam.day3.entity.Ball;
import com.epam.day3.entity.Color;
import com.epam.day3.validator.BallValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BallCreator {

    public Ball createBall() {
        Ball ball = new Ball();
        Random random = new Random();
        double weight = (Math.random() * 1000);
        double volume = (Math.random() * 10);
        ball.setWeight(weight);
        ball.setVolume(volume);
        Color[] colors = {Color.BLUE, Color.BLACK, Color.RED, Color.WHITE, Color.YELLOW};
        int nextColor = random.nextInt(colors.length);
        ball.setColor(colors[nextColor]);
        return ball;
    }

    public List<Ball> createBallsList() {
        BallValidator validator = new BallValidator();
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Ball ball = createBall();
            if (validator.validateBallWeight(ball.getWeight())
                    && validator.validateBallVolume(ball.getVolume())) {
                balls.add(ball);
            }
        }
        return balls;
    }
}
