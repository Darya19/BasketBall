package com.epam.day3.entity;

import com.epam.day3.exception.CustomException;

import java.util.List;

public class Basket {

    private List<Ball> basket;
    private static final double MAX_CAPACITY = 17;

    public Basket() {
    }

    public Basket(List<Ball> basket) {
        this.basket = basket;
    }

    public static double getMaxCapacity() {
        return MAX_CAPACITY;
    }

    public Ball get(int index) {
            return basket.get(index);
    }

    public boolean add(Ball ball) {
        return basket.add(ball);
    }

    public Ball remove(int index) {
            return basket.remove(index);
        }

    public int size() {
            return basket.size();
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Basket basket1 = (Basket) o;

        return basket != null ? basket.equals(basket1.basket) : basket1.basket == null;
    }

    @Override
    public int hashCode() {
        return basket != null ? basket.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Basket{");
        sb.append("basket=").append(basket);
        sb.append('}');
        return sb.toString();
    }
}
