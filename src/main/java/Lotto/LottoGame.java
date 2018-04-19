package Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    private List<Integer> lottoNumberRange;
    private int count;
    private int money;

    private List<List<Integer>> lottoNumbers;

    public LottoGame(int money) {
        lottoNumbers = new ArrayList<>();

        this.count = money / 1000;
        this.money = money;

        lottoNumberRange = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumberRange.add(i);
        }
    }

    public int getCount() {
        return count;
    }

    public List<Integer> lottoNumber() {
        Collections.shuffle(lottoNumberRange);

        List<Integer> lottoNumber = makeLottoNumber();
        Collections.sort(lottoNumber);

        lottoNumbers.add(lottoNumber);

        return lottoNumber;
    }

    private List<Integer> makeLottoNumber() {
        List<Integer> lottoNumber = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            lottoNumber.add(lottoNumberRange.get(i));
        }

        return lottoNumber;
    }

    public LottoGameResult playLottoGame(List<String> winningNumber) {
        LottoGameResult lottoGameResult = new LottoGameResult();

        for (int i = 0; i < count; i++) {
            lottoGameResult.setMatchCount(returnContainNumber(winningNumber, lottoNumbers.get(i)));
        }

        return lottoGameResult;
    }

    public int returnContainNumber(List<String> winnerNumber, List<Integer> lottoNumber) {
        int numberOfWinnerNumber = 0;
        for (int i = 0; i < lottoNumber.size(); i++) {
            numberOfWinnerNumber += checkContainNumber(winnerNumber, lottoNumber.get(i));
        }
        return numberOfWinnerNumber;
    }

    private int checkContainNumber(List<String> winnerNumber, int lottoNumber) {
        return winnerNumber.contains(stringToInt(lottoNumber)) ? 1 : 0;
    }

    private String stringToInt(int lottoNumber) {
        return String.valueOf(lottoNumber);
    }

}