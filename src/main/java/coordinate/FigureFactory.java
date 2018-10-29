package coordinate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {
    private static Map<Shape, FigureCreator> map = new HashMap<>();
    static {
        map.put(Shape.LINE, new LineCreator());
        map.put(Shape.TRIANGLE, new FigureCreator() {
            @Override
            public Figure create(List<Point> points) {
                return new Triangle(points);
            }
        });
        map.put(Shape.RECTANGLE, Rectangle::new);
    }

    static Figure getInstance(List<Point> points) {
        if(!map.containsKey(Shape.obtainShape(points.size()))){
            throw new IllegalArgumentException("유효하지 않은 도형입니다.");
        }
        return map.get(Shape.obtainShape(points.size())).create(points);
    }
}
