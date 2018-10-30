package coordinate;

public enum Shape {
    LINE(2),
    TRIANGLE(3),
    RECTANGLE(4);

    private int countOfPoint;

    Shape(int countOfPoint) {
        this.countOfPoint = countOfPoint;
    }

    public static Shape obtainShape(int countOfPoint) {
        for (Shape shape : values()) {
            if (shape.countOfPoint == countOfPoint) {
                return shape;
            }
        }
        return null;
    }
}
