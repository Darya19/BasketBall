package com.epam.day3.creatorTest;

import com.epam.day3.creater.BasketCreator;
import com.epam.day3.entity.Ball;
import com.epam.day3.entity.Basket;
import com.epam.day3.entity.Color;
import com.epam.day3.exception.CustomException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class BasketCreatorTest {

    BasketCreator creator;

    @BeforeClass
    public void setUp() {
        creator = new BasketCreator();
    }

    @Test
    public void createBasketTest(){
        Basket expected = new Basket(new ArrayList<>(), 45, 1);
        try {
            expected.add(new Ball(250.4, 2.5, Color.RED));
            expected.add(new Ball(500, 5.6, Color.BLUE));
            expected.add(new Ball(3.3, 0.17, Color.YELLOW));
            expected.add(new Ball(117.9, 1.3, Color.BLUE));
            expected.add(new Ball(463.7, 4.9, Color.RED));
            expected.add(new Ball(97.6, 0.9, Color.BLACK));
            Basket actual = creator.createBasket();
            assertEquals(actual, expected);
        }catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void createEmptyBasketTest(){
        Basket actual = creator.createEmptyBasket();
        Basket expected = new Basket(new ArrayList<Ball>(), 15, 1);
        assertEquals(actual, expected);
    }
}
