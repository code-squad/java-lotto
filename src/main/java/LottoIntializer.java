import java.util.ArrayList;
import java.util.List;

public class LottoIntializer {
    private static List<Integer> values = new ArrayList<>();

    public static List<Integer> getValues() {
        if (!values.isEmpty()) {
            return values;
        }

        for (int i = 1; i < 46; i++) {
            values.add(i);
        }
        return values;
    }
}
