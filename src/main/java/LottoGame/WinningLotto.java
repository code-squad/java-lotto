package LottoGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongjong-wan on 2018. 4. 8..
 */
public class WinningLotto {

    private List<Integer> numbers;

    public WinningLotto(String text) {
        this.numbers = createWinningLotto(split(text));

    }
    private static String[] split(String text) {
        return text.split(",");
    }

    private static List<Integer> createWinningLotto(String[] arr) {
        List<Integer> numbers = new ArrayList<>();
        for (String str : arr) {
            numbers.add(Integer.parseInt(trim(str)));
        }
        return numbers;
    }

    private static String trim(String str) {
        return str.trim();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers + "";
    }
}
