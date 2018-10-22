package enumPractice;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

public class FigureFactory {

    public FigureFactory() {

    }

    public enum FigureType {
        LINE(2), TRIANGLE(3), RECTANGLE(4);

        private int countOfPoint;

        /* Method1 - 생성자를 이용해서 enum 객체 값 할당 가능 */
        FigureType(int countOfPoint) {
            this.countOfPoint = countOfPoint;
        }

        /* Method2 - valueOf(String str) : 문자열 str에 해당하는 enum 객체 반환 */
        public FigureType getFigureTypeByName(String name) {
            return valueOf(name);
        }

        public static FigureType getFigureTypeByIndex(int countOfPoint) {
            /* Method3 : values() : enum 객체를 하나씩 반환 */
            for(FigureType figureType : values()) {
                /* Method4 - ordinal() : enum 객체의 index 값을 반환 */
                if(figureType.ordinal() + 2 == countOfPoint)  {
                    return figureType;
                }
            }
            throw new InputMismatchException("잘못입력하셨습니다.");
        }

        public static FigureType getFigureTypeByValue(int countOfPoint) {
            for(FigureType figureType : values()) {
                if(figureType.isFigureType(countOfPoint)) {
                    return figureType;
                }
            }
            throw new InputMismatchException("잘못입력하셨습니다.");
        }

        public boolean isFigureType(int countOfPoint) {
            return this.countOfPoint == countOfPoint;
        }

        public String getName() {
            return name();
        }
    }
    static private Map<FigureType, FigureCreator> mappingFigure = new HashMap<>();
    static {
        mappingFigure.put(FigureType.LINE, new FigureCreator() {
            @Override
            public Figure create(List<Point> points) {
                return new Line(points);
            }
        });

        mappingFigure.put(FigureType.TRIANGLE, (points -> new Triangle(points)));

        mappingFigure.put(FigureType.RECTANGLE, (Rectangle::new));
    }
    static Figure getInstance(List<Point> points) {
        return mappingFigure.get(FigureType.getFigureTypeByValue(points.size())).create(points);
    }
}
