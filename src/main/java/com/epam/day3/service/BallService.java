package com.epam.day3.service;

import com.epam.day3.entity.Ball;
import com.epam.day3.entity.Color;

import java.util.Random;

public class BallService {

    public Ball generateBall() {
        Ball ball = new Ball();
        Random random = new Random();
        int max = 10;
        int min = 1;
        int differ = max - min;
        int weight = (random.nextInt(differ + 1));
        ball.setWeight(weight + min);
        int volume = (random.nextInt(differ + 1));
        ball.setVolume(volume + min);
        Color[] colors = {Color.BLUE, Color.BLACK, Color.RED, Color.WHITE, Color.YELLOW};
        int nextColor = random.nextInt(colors.length);
        ball.setColor(colors[nextColor]);
        return ball;
    }
}
