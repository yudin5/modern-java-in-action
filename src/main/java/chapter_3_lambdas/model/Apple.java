package chapter_3_lambdas.model;

public class Apple extends Fruit {

    public Apple() {
    }

    public Apple(int weight) {
        this.setWeight(weight);
    }

    public Apple(int weight, String country) {
        this.setWeight(weight);
        this.setCountry(country);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + this.getWeight() +
                ", country='" + this.getCountry() + '\'' +
                '}';
    }

}
