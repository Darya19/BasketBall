package com.epam.day3.entity;

import com.epam.day3.exception.CustomException;

import java.util.List;

public class Basket {

    private List<Ball> basket;
    private static double maxCapacity;
    private static double minCapacity;
    public static double occupiedPlace;

    public Basket() {
    }

    public Basket(List<Ball> basket, double maxCapacity, double minCapacity) {
        this.basket = basket;
        Basket.maxCapacity = maxCapacity;
        Basket.minCapacity = minCapacity;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public double getMinCapacity() {
        return minCapacity;
    }

    public void setMinCapacity(double minCapacity) {
        this.minCapacity = minCapacity;
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

        if (Double.compare(basket1.maxCapacity, maxCapacity) != 0) return false;
        if (Double.compare(basket1.minCapacity, minCapacity) != 0) return false;
        return basket != null ? basket.equals(basket1.basket) : basket1.basket == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = basket != null ? basket.hashCode() : 0;
        temp = Double.doubleToLongBits(maxCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(minCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Basket{");
        sb.append("basket=").append(basket);
        sb.append(", maxCapacity=").append(maxCapacity);
        sb.append(", minCapacity=").append(minCapacity);
        sb.append('}');
        return sb.toString();
    }
}
