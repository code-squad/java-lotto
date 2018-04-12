package Lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    private Integer[] lottoNumberRange
            = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45
    };
    private int count;

    public void setCount(int money) {
        count = money / 1000;
    }

    public int getCount() {
        return count;
    }

    public Integer[] lottoNumber() {
        Collections.shuffle(Arrays.asList(lottoNumberRange));

        Integer[] lottoNumber = new Integer[7];
        System.arraycopy(lottoNumberRange, 0, lottoNumber, 0, 7);

        Collections.sort(Arrays.asList(lottoNumber));
        return lottoNumber;
    }

    public int returnContainNumber(List<String> winnerNumber, Integer[] lottoNumbers) {
        int numberOfWinnerNumber = 0;
        for (int i = 0; i < lottoNumbers.length; i++) {
            numberOfWinnerNumber = checkContainNumber(winnerNumber, lottoNumbers[i], numberOfWinnerNumber);
        }
        return numberOfWinnerNumber;
    }

    private int checkContainNumber(List<String> winnerNumber, int lottoNumber, int numberOfWinnerNumber) {
        return winnerNumber.contains(String.valueOf(lottoNumber)) ? ++numberOfWinnerNumber : numberOfWinnerNumber;
    }

}