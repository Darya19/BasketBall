package com.epam.day3.serviceTest;

import com.epam.day3.entity.Ball;
import com.epam.day3.entity.Basket;
import com.epam.day3.entity.Color;
import com.epam.day3.service.BasketService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class BasketServiceTest {

    BasketService service;
    Basket basket;
    List<Ball> balls;

    @BeforeClass
    public void setUp() {
        service = new BasketService();
        balls = new ArrayList<>();
        balls.add(new Ball(194.3, 3.3, Color.BLUE));
        balls.add(new Ball(170.3, 2.0, Color.RED));
        balls.add(new Ball(500.7, 5.6, Color.BLUE));
        balls.add(new Ball(433.7, 4.7, Color.BLACK));
        balls.add(new Ball(217.7, 2.7, Color.BLUE));
        balls.add(new Ball(96.3, 1.2, Color.WHITE));
        balls.add(null);
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
        return new Object[][]{{basket, 528.3}, {basket1, 561.6}};
    }

    @Test
    public void filUpBasketPositiveTest() {
        Basket basket = new Basket(new ArrayList<>());
        Optional<Integer> actual = service.fillUplBasket(basket, balls);
        Optional<Integer> expected = Optional.of(5);
        assertEquals(actual, expected);
    }

    @Test(priority = 1, description = "empty balls List")
    public void filUpBasketEmptyBallsListTest() {
        basket = new Basket(new ArrayList<>());
        balls = new ArrayList<>();
        Optional<Integer> actual = service.fillUplBasket(basket, balls);
        Optional<Integer> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test(priority = 1, description = "balls List is null")
    public void filUpBasketEmptyBallTest() {
        basket = new Basket(new ArrayList<>());
        List<Ball> ball = null;
        Optional<Integer> actual = service.fillUplBasket(basket, ball);
        Optional<Integer> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test(priority = 3, dataProvider = "basket - 2")
    public void countOneColorBallPositiveTest(Basket basket) {
        Optional<Integer> expected = Optional.of(2);
        Optional<Integer> actual = service.countOneColorBall(basket, Color.BLUE);
        assertEquals(actual, expected);
    }

    @Test(priority = 2, dataProvider = "basket - 2")
    public void calculateBallWeightPositiveTest(Basket basket, double expect) {
        Optional<Double> expected = Optional.of(expect);
        Optional<Double> actual = service.calculateBallWeight(basket);
        assertEquals(actual, expected);
    }
}
