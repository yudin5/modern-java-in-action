package part_1_basics.chapter_3.model;

public class Fruit {

    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "weight=" + weight +
                '}';
    }

}
