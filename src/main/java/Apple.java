public class Apple {

    public Apple(){
    }

    public Apple(int weight) {
        this.weight = weight;
    }

    public Apple(int number, int weight) {
        this.number = number;
        this.weight = weight;
    }

    private int weight;
    private int number;
    private String color = "red";

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
        return "Apple{" +
                "weight=" + weight +
                ", number=" + number +
                ", color='" + color + '\'' +
                '}';
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isRedApple(Apple apple) {
        return "red".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
}
