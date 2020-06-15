package com.epam.day3.main;

import com.epam.day3.consoleReader.ConsoleReader;
import com.epam.day3.entity.Ball;
import com.epam.day3.entity.Basket;
import com.epam.day3.exception.CustomException;
import com.epam.day3.parser.Parser;
import com.epam.day3.service.BasketService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws CustomException, IOException {
        BasketService service = new BasketService();
        Basket basket = new Basket();
        ConsoleReader reader = new ConsoleReader();
        Parser parser = new Parser();
        int sum = 0;
        boolean flag = true;
        while (flag) {
            String s = reader.readString();
            Ball ball = parser.parseToBall(s);
            if(ball.getVolume()> basket.getMAX_CAPACITY() - sum ){
               flag = false;
            }
            sum += ball.getVolume();
            basket = service.fillBasket(ball, basket);
            System.out.println(basket.toString());
        }
    }
}
