package com.epam.day3.entity;

public enum Color {
    BLUE ("Blue"),
    YELLOW ("Yellow"),
    RED ("Red"),
    BLACK ("Black"),
    WHITE ("White");

    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Color{");
        sb.append("color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
