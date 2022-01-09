package part_1_basics.chapter_3.model;

public class Fruit {

    private int weight;
    private String country;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "weight=" + weight +
                ", country='" + country + '\'' +
                '}';
    }

}
