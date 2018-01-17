package domain;

import dto.LottosDto;
import dto.ResultDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoSystem {
    private int price;
    public List<Lotto> userLottos;
    private Map<Integer, Integer> winningPrice;
    private Map<Integer, Integer> winningCount;

    public LottoSystem() {
        winningPrice = new HashMap<>();
        winningPrice.put(3, 5000);
        winningPrice.put(4, 50000);
        winningPrice.put(5, 1500000);
        winningPrice.put(6, 2000000000);
        winningCount = new HashMap<>();
        winningCount.put(3, 0);
        winningCount.put(4, 0);
        winningCount.put(5, 0);
        winningCount.put(6, 0);
    }

    public int countOfLotto() {
        return price / 1000;
    }

    public LottosDto makeLottos(int price) {
        this.price = price;
        userLottos = LottoFactory.makeLottos(countOfLotto());
        return new LottosDto(userLottos);
    }

    public ResultDto checkLastWinningNumbers(String lastWinningNumbers) {
        Lotto numbers = new Lotto(parseInts(split(lastWinningNumbers)));
        for (Lotto lotto : userLottos) {
            int count = lotto.checkTheWinningNumbers(numbers);
            if (winningCount.containsKey(count)) {
                winningCount.put(count, winningCount.get(count) + 1);
            }
        }
        return new ResultDto(winningPrice, winningCount, calRevenue());
    }

    private String[] split(String text) {
        return text.split("(, )");
    }

    private List<Integer> parseInts(String[] numbersText) {
        List<Integer> numbers = new ArrayList<>();
        for (String numberText : numbersText) {
            int a = parseInt(numberText);
            numbers.add(a);
        }
        return numbers;
    }

    private int parseInt(String numberText) {
        return Integer.parseInt(numberText);
    }

    public int calRevenue() {
        float max = 0;
        for (int i = 3; i <= 6; i++) {
            if (winningCount.get(i) > 0) {
                max += winningCount.get(i) * winningPrice.get(i);
            }
        }
        return Math.round(max / price * 100) - 100;
    }
}
