package part_1_basics.chapter_2;

import part_1_basics.chapter_2.model.Apple;
import part_1_basics.chapter_2.model.ApplePredicate;

import static part_1_basics.chapter_2.model.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
