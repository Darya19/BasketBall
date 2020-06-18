package com.epam.day3.entity;

import com.epam.day3.exception.CustomException;

import java.util.List;

public class Basket {

    private List<Ball> basket;
    private static final double MAX_CAPACITY = 17;
    private static final double MIN_CAPACITY = 1;
    public static double occupiedPlace;

    public Basket() {
    }

    public Basket(List<Ball> basket) {
        this.basket = basket;
    }

    public static double getMaxCapacity() {
        return MAX_CAPACITY;
    }

    public static double getMinCapacity() {
        return MIN_CAPACITY;
    }

    public Ball get(int index) throws CustomException {
        if (basket.get(index) == null) {
            throw new CustomException("ball don't exist");
        } else {
            return basket.get(index);
        }
    }

    public boolean add(Ball ball) throws CustomException {
        if (ball == null) {
            throw new CustomException("empty ball");
        }
        return basket.add(ball);
    }

    public Ball remove(int index) throws CustomException {
        if (basket.get(index) == null) {
            throw new CustomException("ball don't exist");
        } else {
            return basket.remove(index);
        }
    }

    public int size() throws CustomException {
        if (basket == null) {
            throw new CustomException("basket is empty");
        } else {
            return basket.size();
        }
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
