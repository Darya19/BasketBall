package com.epam.day3.service;

import com.epam.day3.entity.Ball;
import com.epam.day3.entity.Basket;
import com.epam.day3.entity.Color;

import java.util.List;
import java.util.Optional;

public class BasketService {

    public Optional<Integer> fillUplBasket(Basket basket, List<Ball> balls) {
        double occupiedPlace = 0;
        int count = 0;
        if (balls == null || balls.size() == 0) {
            return Optional.empty();
        } else {
            for (int i = 0; i < balls.size(); i++) {
                if (balls.get(i) == null) {
                    i++;
                } else {
                    if ((Basket.getMaxCapacity() - occupiedPlace) > balls.get(i).getVolume()) {
                        basket.add(balls.get(i));
                        occupiedPlace += balls.get(i).getVolume();
                        count++;
                    }
                }
            }
            return Optional.of(count);
        }
    }

    public Optional<Integer> countOneColorBall(Basket basket, Color color) {
        int count = 0;
        for (int i = 0; i < basket.size(); i++) {
            if (basket.get(i).getColor() == color) {
                count++;
            }
        }
        return Optional.of(count);
    }

    public Optional<Double> calculateBallWeight(Basket basket) {
        double sumWeight = 0;
        for (int i = 0; i < basket.size(); i++) {
            sumWeight = (sumWeight + basket.get(i).getWeight());
        }
        return Optional.of(sumWeight);
    }
}
