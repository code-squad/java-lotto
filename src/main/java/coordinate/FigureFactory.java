package coordinate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {
    static Map<Type, FigureCreator> figures = new HashMap<>();
    static {
        figures.put(Type.LINE, points -> new Line(points));
        figures.put(Type.TRIANGLE, points -> new Triangle(points));
        figures.put(Type.RECTANGLE, points -> new Rectangle(points));
    }

    static Figure getInstance(List<Point> points) {
        Type type = Type.findType(points.size());
        if (type == null) {
            throw new IllegalArgumentException("유효하지 않은 도형입니다.");
        }
        return figures.get(type).create(points);
    }
}
