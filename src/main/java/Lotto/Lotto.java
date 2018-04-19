package Lotto;

import java.util.*;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private List<LottoNumber> lottoTicket;

    public Lotto(List<LottoNumber> lotto) {
        if (lotto.isEmpty() || lotto == null) {
            throw new IllegalArgumentException();
        }

        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        this.lottoTicket = lotto;
    }

    public static Lotto makeLottoNumber() {
        Set<LottoNumber> lottoNumber = new HashSet<>();
        while (lottoNumber.size() < LOTTO_SIZE) {
            lottoNumber.add(LottoNumber.getLottoNumber(randomNumber()));
        }
        return new Lotto(setToList(lottoNumber));
    }

    private static Integer randomNumber() {
        return (int) (Math.random() * 45) + 1;
    }

    public static Lotto makeWinningNumber(List<String> winningNumber) {
        Set<LottoNumber> lottoNumber = new HashSet<>();
        for (String number : winningNumber) {
            lottoNumber.add(LottoNumber.getLottoNumber(number));
        }
        return new Lotto(setToList(lottoNumber));
    }

    public static List<LottoNumber> setToList(Set<LottoNumber> lottoNumber) {
        return sort(new ArrayList<>(lottoNumber));
    }

    public static List<LottoNumber> sort(List<LottoNumber> lottoNumber) {
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

    public boolean makeBonusNumber(int bonus) {
        return this.lottoTicket.contains(new LottoNumber(bonus));
    }

    public int checkBonusNumber(int bonus) {
        if (this.lottoTicket.contains(new LottoNumber(bonus))) {
            throw new IllegalArgumentException();
        }
        return bonus;
    }

    public int contains(Lotto lotto) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : this.lottoTicket) {
            matchCount += containsLottoNumber(lottoNumber, lotto);
        }
        return matchCount;
    }

    public int containsLottoNumber(LottoNumber lottoNumber1, Lotto lotto) {
        return lotto.lottoTicket.contains(lottoNumber1) ? 1 : 0;
    }

    public String toString() {
        return lottoTicket.toString();
    }

}