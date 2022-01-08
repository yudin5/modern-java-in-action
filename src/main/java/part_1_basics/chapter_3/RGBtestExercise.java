package part_1_basics.chapter_3;

import part_1_basics.chapter_3.model.RGB;

public class RGBtestExercise {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, RGB> rgbCreator = RGB::new;
        RGB rgb = rgbCreator.apply(100, 200, 300);
        System.out.println("rgb = " + rgb);
    }
}
