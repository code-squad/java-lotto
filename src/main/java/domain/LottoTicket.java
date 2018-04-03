package domain;

import java.util.List;

public class LottoTicket {
    private List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) throws Exception {
        if (!isValid(numbers)) {
            throw new IllegalArgumentException("\n로또 번호를 다시 입력해주세요. 6자리 - 1~45");
        }
        this.numbers = numbers;
    }

    private boolean isValid(List<Integer> numbers) {
        if (numbers.size() > 6 || numbers.size() <= 5) {
            return false;
        }
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchedCount(LottoTicket winningLottoTicket) {
        int matchedCount = 0;
        List<Integer> winningNumbers = winningLottoTicket.getNumbers();
        for (Integer number : winningNumbers) {
            if (this.numbers.contains(number)) {
                matchedCount++;
            }
        }
        return matchedCount;
    }
}
