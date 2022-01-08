package part_1_basics.chapter_3.model;

public class Apple extends Fruit {

    public Apple() {
    }

    public Apple(int weight) {
        this.setWeight(weight);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + this.getWeight() +
                '}';
    }

}
