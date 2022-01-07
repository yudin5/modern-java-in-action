package part_1_basics.chapter_2;

import part_1_basics.chapter_2.model.Apple;
import part_1_basics.chapter_2.model.AppleFormatter;

public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String weightCharacteristic = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + weightCharacteristic + " " + apple.getColor() + " apple";
    }
}
