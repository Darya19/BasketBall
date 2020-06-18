package com.epam.day3.serviceTest;

import com.epam.day3.entity.Ball;
import com.epam.day3.entity.Basket;
import com.epam.day3.entity.Color;
import com.epam.day3.exception.CustomException;
import com.epam.day3.service.BasketService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class BasketServiceTest {

    BasketService service;
    Basket basket;
    Basket basket1;
    List<Ball> balls;

    @BeforeClass
    public void setUp() {
        service = new BasketService();
        balls = new ArrayList<Ball>();
        balls.add(new Ball(194.3, 3.3, Color.BLUE));
        balls.add(new Ball(170.3, 2.0, Color.RED));
        balls.add(new Ball(163.7, 1.9, Color.BLUE));
        balls.add(new Ball(133.7, 1.7, Color.BLACK));
    }

    @DataProvider(name = "basket - 2")
    public Object[] createBasket() {
        basket = new Basket(new ArrayList<>());
        basket1 = new Basket(new ArrayList<>());
        try {
            basket.add(new Ball(194.3, 3.3, Color.BLUE));
            basket.add(new Ball(170.3, 2.0, Color.RED));
            basket.add(new Ball(163.7, 1.9, Color.BLUE));
            basket1.add(new Ball(178.3, 3.3, Color.BLUE));
            basket1.add(new Ball(14.3, 0.22, Color.RED));
            basket1.add(new Ball(369, 4.2, Color.BLUE));
        } catch (CustomException e) {
            fail();
        }
        Basket[] baskets = new Basket[2];
        baskets[0] = basket;
        baskets[1] = basket1;
        return baskets;
    }

    @Test(priority = 0, enabled = true, expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "basket is empty")
    public void calculateOccupiedPlaceNegativeTest() throws CustomException {
        service.calculateOccupiedPlace(basket);
    }

    @Test(priority = 3, dataProvider = "basket - 2")
    public void calculateOccupiedPlacePositiveTest(Basket basket) {
        try {
            double expected = 0;
            double actual = service.calculateOccupiedPlace(basket);
            for (int i = 0; i < basket.size(); i++) {
                expected += basket.get(i).getVolume();
            }
            assertEquals(actual, expected, 0.1);
        } catch (CustomException e) {
            fail();
        }

    }


    @Test(priority = 2)
    public void filUpBasketPositiveTest() {
        Basket basket = new Basket(new ArrayList<Ball>());
        try {
            double actual = service.fillUplBasket(balls, basket);
            double expected = 17 - 3.3 - 2.0 - 1.9 - 1.7;
            assertEquals(actual, expected, 0.01);
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(priority = 1, enabled = true, expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "basket is empty")
    public void filUpBasketNegativeTest() throws CustomException {
        service.fillUplBasket(balls, basket);
    }

    @Test(priority = 3, dataProvider = "basket - 2")
    public void countOneColorBallPositiveTest(Basket basket) {
        try {
            int expected = 2;
            int actual = service.countOneColorBall(basket, Color.BLUE);
            assertEquals(actual, expected);
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(priority = 1, enabled = true, expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "basket is empty")
    public void countOneColorBallNegativeTest() throws CustomException {
        service.countOneColorBall(basket, Color.BLUE);
    }

    @Test(priority = 2)
    public void calculateBallWeightPositiveTest() {
        basket = new Basket(new ArrayList<>());
        try {
            basket.add(new Ball(194.3, 3.3, Color.BLUE));
            basket.add(new Ball(170.3, 2.0, Color.RED));
            basket.add(new Ball(163.7, 1.9, Color.BLUE));
            double expected = 194.3 + 170.3 + 163.7;
            double actual = service.calculateBallWeight(basket);
            assertEquals(actual, expected, 0.01);
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(priority = 1, enabled = true, expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "basket is empty")
    public void calculateBallWeightNegativeTest() throws CustomException {
        service.calculateBallWeight(basket);
    }

}
