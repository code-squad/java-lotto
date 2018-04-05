package domain;

import java.util.List;

public class WinningLotto {
    private static final int LOTTO_MAX_SIZE = 6;

    private List<LottoNo> numbers;
    private LottoNo bonus;

    public WinningLotto(List<LottoNo> numbers, LottoNo bonus) {
        if (!isValid(numbers)) {
            throw new IllegalArgumentException("로또 번호 6개를 입력해 주세요.");
        }
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private static boolean isValid(List<LottoNo> numbers) {
        if (numbers.size() != LOTTO_MAX_SIZE) {
            throw new IllegalArgumentException("로또 번호 6개를 입력해 주세요.");
        }
        return true;
    }

    public boolean isMatchedBonus(LottoTicket lottoTicket) {
        if (lottoTicket.contains(bonus)) {
            return true;
        }
        return false;
    }

    public int getMatchedNo(LottoTicket lottoTicket) {
        int matchedNoCount = 0;
        for (LottoNo number : numbers) {
            if (lottoTicket.contains(number)) {
                matchedNoCount++;
            }
        }
        return matchedNoCount;
    }

    public Rank match(LottoTicket lottoTicket) {
        return Rank.valueOf(getMatchedNo(lottoTicket), isMatchedBonus(lottoTicket));
    }
}
