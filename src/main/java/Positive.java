import java.util.Collections;
import java.util.List;

public class Positive {

    List<Integer> split;

    Positive() {
        this.split = Collections.EMPTY_LIST;
    }

    Positive(List<Integer> split) {
        this.split = split;
    }

    public List<Integer> getSplit() {
        return this.split;
    }
}
