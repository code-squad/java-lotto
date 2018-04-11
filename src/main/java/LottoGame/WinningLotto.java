package LottoGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongjong-wan on 2018. 4. 8..
 */
public class WinningLotto {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningLotto(String text, int bonusNumber) {
        this.winningNumbers = createWinningLotto(split(text));
        this.bonusNumber = bonusNumber;
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


    public int getMatchCount(List<Integer> numbers) {
        int matchCount = 0;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean matchBonus(List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

}