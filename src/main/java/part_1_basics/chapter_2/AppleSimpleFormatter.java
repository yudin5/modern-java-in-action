package part_1_basics.chapter_2;

import part_1_basics.chapter_2.model.Apple;
import part_1_basics.chapter_2.model.AppleFormatter;

public class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
