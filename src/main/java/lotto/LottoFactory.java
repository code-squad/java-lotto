package lotto;

import java.util.*;

public class LottoFactory extends Lotto {

    private LottoFactory(List<LottoNumber> lottoTicket) {
        super(lottoTicket);
    }

    public static Lotto makeAutoLottoNumber() {
        Set<LottoNumber> lottoNumber = new HashSet<>();
        while (lottoNumber.size() < LOTTO_SIZE) {
            lottoNumber.add(LottoNumber.getLottoNumber(randomNumber()));
        }
        return new Lotto(setToList(lottoNumber));
    }

    private static Integer randomNumber() {
        return (int) (Math.random() * 45) + 1;
    }

    public static List<Lotto> makeManualLottoNumbers(java.util.List<String> inputLottoNumbers) throws IllegalArgumentException {
        List<lotto.Lotto> manualLottoNumbers = new ArrayList<>();
        for (String inputLottoNumber : inputLottoNumbers) {
            manualLottoNumbers.add(makeLottoNumber(stringToList(inputLottoNumber)));
        }
        return manualLottoNumbers;
    }

    public static Lotto makeManualLottoNumber(String inputLottoNumber) throws IllegalArgumentException {
        return makeLottoNumber(stringToList(inputLottoNumber));
    }

    private static Lotto makeLottoNumber(List<String> manualLottoNumber) throws IllegalArgumentException {
        Set<LottoNumber> lottoNumber = new HashSet<>();
        for (String number : manualLottoNumber) {
            lottoNumber.add(LottoNumber.getLottoNumber(number));
        }
        return new Lotto(setToList(lottoNumber));
    }

    private static List<String> stringToList(String lottoNumber) {
        return split(lottoNumber);
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

    private static List<LottoNumber> setToList(Set<LottoNumber> lottoNumber) {
        return sort(new ArrayList<>(lottoNumber));
    }

    private static List<LottoNumber> sort(List<LottoNumber> lottoNumber) {
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

}