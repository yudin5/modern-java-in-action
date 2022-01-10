package part_1_basics.chapter_3_lambdas.model;

public class Orange extends Fruit {

    public Orange() {
    }

    public Orange(int weight) {
        this.setWeight(weight);
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + this.getWeight() +
                '}';
    }

}