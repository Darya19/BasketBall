package com.epam.day3.serviceTest;

import com.epam.day3.entity.Ball;
import com.epam.day3.entity.Basket;
import com.epam.day3.entity.Color;
import com.epam.day3.service.BasketService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class BasketServiceTest {

    private BasketService service;
    private Basket basket;
    private Ball[] balls;

    @BeforeClass
    public void setUp() {
        service = new BasketService();
        balls = new Ball[5];
        balls[0] = new Ball(194.3, 3.3, Color.BLUE);
        balls[1] = new Ball(170.3, 2.0, Color.RED);
        balls[2] = new Ball(500.7, 5.6, Color.BLUE);
        balls[3] = new Ball(433.7, 4.7, Color.BLACK);
        balls[4] = new Ball(217.7, 2.7, Color.BLUE);
    }

    @DataProvider(name = "basket - 2")
    public Object[] createBasket() {
        basket = new Basket(new ArrayList<>());
        Basket basket1 = new Basket(new ArrayList<>());
        basket.add(new Ball(194.3, 3.3, Color.BLUE));
        basket.add(new Ball(170.3, 2.0, Color.RED));
        basket.add(new Ball(163.7, 1.9, Color.BLUE));
        basket1.add(new Ball(178.3, 3.3, Color.BLUE));
        basket1.add(new Ball(14.3, 0.22, Color.RED));
        basket1.add(new Ball(369, 4.2, Color.BLUE));
        Basket[] baskets = new Basket[2];
        baskets[0] = basket;
        baskets[1] = basket1;
        return baskets;
    }

    @Test(priority = 2)
    public void filUpBasketPositiveTest() {
        Basket basket = new Basket(new ArrayList<>());
        Optional<Integer> actual = service.fillUplBasket(basket, balls);
        Optional<Integer> expected = Optional.of(4);
        assertEquals(actual, expected);
    }

    @Test(description = "test empty basket")
    public void filUpBasketEmptyBasketTest() {
        Optional<Integer> actual = service.fillUplBasket(basket, balls);
        Optional<Integer> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test(priority = 1, description = "test empty ball")
    public void filUpBasketEmptyBallTest() {
        basket = new Basket(new ArrayList<>());
        Optional<Integer> actual = service.fillUplBasket(basket, null);
        Optional<Integer> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test(priority = 3, dataProvider = "basket - 2")
    public void countOneColorBallPositiveTest(Basket basket) {
        Optional<Integer> expected = Optional.of(2);
        Optional<Integer> actual = service.countOneColorBall(basket, Color.BLUE);
        assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void countOneColorBallNegativeTest() {
        Optional<Integer> expected = Optional.empty();
        Optional<Integer> actual = service.countOneColorBall(basket, Color.BLUE);
        assertEquals(actual, expected);
    }

    @Test(priority = 2)
    public void calculateBallWeightPositiveTest() {
        basket = new Basket(new ArrayList<>());
        basket.add(new Ball(194.3, 3.3, Color.BLUE));
        basket.add(new Ball(170.3, 2.0, Color.RED));
        basket.add(new Ball(163.7, 1.9, Color.BLUE));
        Optional<Double> expected = Optional.of(194.3 + 170.3 + 163.7);
        Optional<Double> actual = service.calculateBallWeight(basket);
        assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void calculateBallWeightNegativeTest() {
        Optional<Double> actual = service.calculateBallWeight(basket);
        Optional<Double> expected = Optional.empty();
        assertEquals(actual, expected);
    }
}
