package part_1_basics.chapter_2;

import part_1_basics.chapter_2.model.Apple;
import part_1_basics.chapter_2.model.ApplePredicate;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
