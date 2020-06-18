package com.epam.day3.main;

import com.epam.day3.creater.BallCreator;
import com.epam.day3.creater.BasketCreator;
import com.epam.day3.entity.Ball;
import com.epam.day3.entity.Basket;
import com.epam.day3.entity.Color;
import com.epam.day3.exception.CustomException;
import com.epam.day3.service.BasketService;

import java.util.List;

public class Main {
    public static void main(String[] args) throws CustomException {
        BasketCreator creator = new BasketCreator();
        BallCreator ballCreator = new BallCreator();
       List<Ball> ball = ballCreator.createBallsList();
       Basket basket = creator.createEmptyBasket();
       BasketService service = new BasketService();
       double occupiedPlace = service.calculateOccupiedPlace(basket);
        System.out.println(Basket.occupiedPlace);
        service.fillUplBasket(ball, basket);
           System.out.println("yes");
           System.out.println(Basket.occupiedPlace);
         double weight = service.calculateBallWeight(basket);
         int count = service.countOneColorBall(basket, Color.BLUE);
        System.out.println("weight  " + weight +" blue " + count);
        System.out.println(basket.toString());
    }
}
