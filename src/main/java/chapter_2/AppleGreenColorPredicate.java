package chapter_2;

import chapter_2.model.Apple;
import chapter_2.model.ApplePredicate;

import static chapter_2.model.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
