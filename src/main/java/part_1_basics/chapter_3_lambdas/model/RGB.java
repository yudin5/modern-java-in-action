package part_1_basics.chapter_3_lambdas.model;

public class RGB {

    private final int x;
    private final int y;
    private final int z;

    public RGB(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "RGB{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

}
