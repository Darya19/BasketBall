package com.epam.day3.service;

import com.epam.day3.entity.Ball;
import com.epam.day3.entity.Basket;
import com.epam.day3.entity.Color;
import com.epam.day3.exception.CustomException;

import java.util.List;
import java.util.Optional;

public class BasketService {

    public Optional<Integer> fillUplBasket(Basket basket, Ball ... ball) {
        double occupiedPlace = 0;
        int count = 0;
        if (basket == null || ball == null) {
            return Optional.empty();
        } else {
            for (int i = 0; i < ball.length; i++) {
                    if ((Basket.getMaxCapacity() - occupiedPlace) > ball[i].getVolume()) {
                        basket.add(ball[i]);
                        occupiedPlace += ball[i].getVolume();
                        count++;
                    }
                }
                return Optional.of(count);
        }
    }

    public Optional<Integer> countOneColorBall(Basket basket, Color color) {
        if (basket == null) {
            return Optional.empty();
        } else {
                int count = 0;
                for (int i = 0; i < basket.size(); i++) {
                    if (basket.get(i).getColor() == color) {
                        count++;
                    }
                }
                return Optional.of(count);
            }
        }

    public Optional<Double> calculateBallWeight(Basket basket) {
        if (basket == null) {
            return Optional.empty();
        } else {
                double sumWeight = 0;
                for (int i = 0; i < basket.size(); i++) {
                    sumWeight = (sumWeight + basket.get(i).getWeight());
                }
                return Optional.of(sumWeight);
        }
    }
}
