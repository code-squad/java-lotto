package domain;

import java.util.List;

public class LottoTicket {
    private static final int LOTTO_SIZE = 6;
    private List<Integer> numbers;
    private boolean bonus = false;

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

    public boolean hasBonusNumber(Integer bonusNumber) {
        if ((bonusNumber > 0 || bonusNumber < 46) && this.numbers.contains(bonusNumber)) {
            bonus = true;
            return bonus;
        }
        return bonus;
    }

    public int getMatchedCount(LottoTicket winningLottoTicket) {
        List<Integer> winningNumbers = winningLottoTicket.getNumbers();
        this.numbers.removeAll(winningNumbers);
        return LOTTO_SIZE - numbers.size();
    }
}