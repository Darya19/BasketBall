package com.epam.day3.entity;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Ball> basket = new ArrayList<Ball>();
    private final int MAX_CAPACITY = 74;

    public Basket() {
    }

    public List<Ball> getBasket() {
        return basket;
    }

    public void setBasket(Ball ball) {
        this.basket.add(ball);
    }

    public int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Basket basket1 = (Basket) o;

        if (MAX_CAPACITY != basket1.MAX_CAPACITY) return false;
        return basket != null ? basket.equals(basket1.basket) : basket1.basket == null;
    }

    @Override
    public int hashCode() {
        int result = basket != null ? basket.hashCode() : 0;
        result = 31 * result + MAX_CAPACITY;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Basket{");
        sb.append("basket=").append(basket);
        sb.append(", MAX_CAPACITY=").append(MAX_CAPACITY);
        sb.append('}');
        return sb.toString();
    }
}
