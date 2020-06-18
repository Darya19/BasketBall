package com.epam.day3.creater;

import com.epam.day3.entity.Ball;
import com.epam.day3.entity.Basket;
import com.epam.day3.entity.Color;

import java.util.ArrayList;
import java.util.List;

public class BasketCreator {

    public Basket createBasket() {
        List<Ball> balls = new ArrayList<>();
        balls.add(new Ball(250.4, 2.5, Color.RED));
        balls.add(new Ball(500, 5.6, Color.BLUE));
        balls.add(new Ball(3.3, 0.17, Color.YELLOW));
        balls.add(new Ball(117.9, 1.3, Color.BLUE));
        balls.add(new Ball(463.7, 4.9, Color.RED));
        balls.add(new Ball(97.6, 0.9, Color.BLACK));
        Basket basket = new Basket(balls);
        return basket;
    }

    public Basket createEmptyBasket() {
        Basket basket = new Basket(new ArrayList<>());
        return basket;
    }
}
