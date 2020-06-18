package com.epam.day3.service;

import com.epam.day3.entity.Ball;
import com.epam.day3.entity.Basket;
import com.epam.day3.entity.Color;
import com.epam.day3.exception.CustomException;

import java.util.List;

public class BasketService {

    public double calculateOccupiedPlace(Basket basket) throws CustomException {
        if (basket == null) {
            throw new CustomException("basket is empty");
        } else {
            Basket.occupiedPlace = 0;
            for (int i = 0; i < basket.size(); i++) {
                Basket.occupiedPlace += basket.get(i).getVolume();
            }
            return Basket.occupiedPlace;
        }
    }

    public double fillUplBasket(List<Ball> balls, Basket basket) throws CustomException {
        double freePlace;
        if (basket == null) {
            throw new CustomException("basket is empty");
        } else {
            for (int i = 0; i < balls.size(); i++) {
                if ((basket.getMaxCapacity() - Basket.occupiedPlace) > balls.get(i).getVolume()) {
                    basket.add(balls.get(i));
                    Basket.occupiedPlace += balls.get(i).getVolume();
                }
            }
            freePlace = basket.getMaxCapacity() - Basket.occupiedPlace;
        }
        return freePlace;
    }

    public int countOneColorBall(Basket basket, Color color) throws CustomException {
        if (basket == null) {
            throw new CustomException("basket is empty");
        } else {
            int count = 0;
            for (int i = 0; i < basket.size(); i++) {
                if (basket.get(i).getColor() == color) {
                    count++;
                }
            }
            return count;
        }
    }

    public double calculateBallWeight(Basket basket) throws CustomException {
        if (basket == null) {
            throw new CustomException("basket is empty");
        } else {
            double sumWeigh = 0;
            for (int i = 0; i < basket.size(); i++) {
                sumWeigh = (sumWeigh + basket.get(i).getWeight());
            }
            return sumWeigh;
        }
    }
}
