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

    public static String[] split(String text) {
        return text.split(",");
    }

    public static List<Integer> createWinningLotto(String[] arr) {
        List<Integer> numbers = new ArrayList<>();
        for (String str : arr) {
            numbers.add(Integer.parseInt(trim(str)));
        }
        return numbers;
    }

    public static String trim(String str) {
        return str.trim();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCount(List<Integer> numbers) {
        int matchCount = 0;
        for (Integer number : numbers) {
            if (numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }


    @Override
    public String toString() {
        return numbers + "";
    }

}
