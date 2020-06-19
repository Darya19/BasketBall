package com.epam.day3.creator;

import com.epam.day3.entity.Basket;

import java.util.ArrayList;

public class BasketCreator {

    public Basket createEmptyBasket() {

        Basket basket = new Basket(new ArrayList<>());
        return basket;
    }
}
