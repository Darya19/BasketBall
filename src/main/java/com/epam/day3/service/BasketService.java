package com.epam.day3.service;

import com.epam.day3.consoleReader.ConsoleReader;
import com.epam.day3.parser.Parser;
import com.epam.day3.entity.Ball;
import com.epam.day3.entity.Basket;
import com.epam.day3.entity.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasketService {

    public Basket fillBasket(Ball ball, Basket basket) throws IOException {
        double sumVolume = 0;
        for (int i = 0; i < basket.getBasket().size() ; i++) {
            sumVolume += basket.getBasket().get(i).getVolume();
        }
            if ((basket.getMAX_CAPACITY() - sumVolume) > ball.getVolume()) {
                basket.setBasket(ball);
            }
      /*  Basket basket = new Basket();
        BallService service = new BallService();
        double sumVolumeOfBalls = 0;
           Ball newBall = service.generateBall();
            sumVolumeOfBalls += newBall.getVolume();
            if ((basket.getMAX_CAPACITY() - sumVolumeOfBalls) > newBall.getVolume()) {
            basket.setBasket(newBall); }*/
        return basket;
    }

    public  boolean isNotFullBasket(Basket basket) {
        int sumVolume = 0;
        for (int i = 0; i < basket.getBasket().size() ; i++) {
            sumVolume += basket.getBasket().get(i).getVolume();
        }
            return (basket.getMAX_CAPACITY() > sumVolume);
    }

    public int countBlueBall(Basket basket) {
        int count = 0;
        for (int i = 0; i < basket.getBasket().size(); i++) {
            if (basket.getBasket().get(i).getColor() == Color.BLUE) {
                count++;
            }
        }
        return count;
    }

    public int calculateBallWeight(Basket basket) {
        int sumWeigh = 0;
        for (int i = 0; i < basket.getBasket().size(); i++) {
            sumWeigh += basket.getBasket().get(i).getWeight();
        }
        return sumWeigh;
    }
}
