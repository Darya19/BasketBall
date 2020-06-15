package com.epam.day3.entity;

public class Ball {

    private int weight;
    private double volume;
    private Color color;

    public Ball() {
    }

    public Ball(int weight, double volume, Color color) {
        this.weight = weight;
        this.volume = volume;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ball ball = (Ball) o;

        if (weight != ball.weight) return false;
        if (Double.compare(ball.volume, volume) != 0) return false;
        return color == ball.color;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = weight;
        temp = Double.doubleToLongBits(volume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ball{");
        sb.append("weight=").append(weight);
        sb.append(", volume=").append(volume);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
