package Lotto;

import Lotto.Exception.DuplicatedBonusNumberException;
import Lotto.Exception.IllegalLottoNumberFormatException;

import java.util.*;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private List<LottoNumber> lottoTicket;

    public Lotto(List<LottoNumber> lottoTicket) {
        if (lottoTicket == null || lottoTicket.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (lottoTicket.size() != LOTTO_SIZE) {
            throw new IllegalLottoNumberFormatException();
        }

        this.lottoTicket = lottoTicket;
    }

    public static Lotto makeLottoNumber() {
        Set<LottoNumber> lottoNumber = new HashSet<>();
        while (lottoNumber.size() < LOTTO_SIZE) {
            lottoNumber.add(LottoNumber.getLottoNumber(randomNumber()));
        }
        return new Lotto(setToList(lottoNumber));
    }

    public static Lotto makeLottoNumber(List<String> manualLottoNumber) throws IllegalArgumentException {
        Set<LottoNumber> lottoNumber = new HashSet<>();
        for (String number : manualLottoNumber) {
            lottoNumber.add(LottoNumber.getLottoNumber(number));
        }
        return new Lotto(setToList(lottoNumber));
    }

    private static Integer randomNumber() {
        return (int) (Math.random() * 45) + 1;
    }

    public static Lotto makeManualLottoNumber(String inputLottoNumber) throws IllegalArgumentException {
        return makeLottoNumber(stringToList(inputLottoNumber));
    }

    public static List<LottoNumber> setToList(Set<LottoNumber> lottoNumber) {
        return sort(new ArrayList<>(lottoNumber));
    }

    public static List<LottoNumber> sort(List<LottoNumber> lottoNumber) {
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

    public int checkDuplicateBonusNumber(int bonus) {
        if (isContainsBonusNumber(bonus)) {
            throw new DuplicatedBonusNumberException();
        }
        return bonus;
    }

    public boolean isContainsBonusNumber(int bonus) {
        return this.lottoTicket.contains(new LottoNumber(bonus));
    }

    public int countMatchLottoNumber(Lotto lotto) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : this.lottoTicket) {
            matchCount += containsLottoNumber(lottoNumber, lotto);
        }
        return matchCount;
    }

    public int containsLottoNumber(LottoNumber lottoNumber, Lotto lotto) {
        return lotto.lottoTicket.contains(lottoNumber) ? 1 : 0;
    }

    public String toString() {
        return lottoTicket.toString();
    }

    private static List<String> stringToList(String winnerNumber) {
        return split(winnerNumber);
    }

    private static List<String> split(String winnerNumber) {
        return Arrays.asList(trim(winnerNumber.split(",")));
    }

    private static String[] trim(String[] winnerNumbers) {
        for (String winnerNumber : winnerNumbers) {
            winnerNumber.trim();
        }
        return winnerNumbers;
    }

}