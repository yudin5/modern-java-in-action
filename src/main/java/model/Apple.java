package model;

public class Apple {

    private int weight;
    private int number;
    private String color = "red";

    public Apple(int number, int weight) {
        this.number = number;
        this.weight = weight;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static boolean isRedApple(Apple apple) {
        return "red".equals(apple.getColor());
    }


    // Конструкторы
    public Apple() {
    }

    public Apple(int weight) {
        this.weight = weight;
    }

    // Геттеры, сеттеры
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "model.Apple #" + getNumber() + ", weight = " + getWeight() + ", color = " + getColor();
    }
}
