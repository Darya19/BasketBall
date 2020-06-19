package com.epam.day3.creatorTest;

import com.epam.day3.creator.BasketCreator;
import com.epam.day3.entity.Basket;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class BasketCreatorTest {

    private BasketCreator creator;

    @BeforeClass
    public void setUp() {
        creator = new BasketCreator();
    }

    @Test
    public void createEmptyBasketTest() {
        Basket actual = creator.createEmptyBasket();
        Basket expected = new Basket(new ArrayList<>());
        assertEquals(actual, expected);
    }
}
