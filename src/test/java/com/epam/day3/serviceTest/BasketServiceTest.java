package com.epam.day3.serviceTest;

import com.epam.day3.entity.Basket;
import com.epam.day3.service.BasketService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasketServiceTest {

    BasketService service;
    Basket basket;

   @BeforeClass
           public void setUp(){
       service = new BasketService();
   }

    @BeforeMethod
    public void createList(){
basket = new Basket();

    }

    @Test
    public void fillBasket() {

    }
}
