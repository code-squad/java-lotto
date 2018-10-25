package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.LottoGameValues.LOTTO_NUM_END;
import static utils.LottoGameValues.LOTTO_NUM_START;
import static utils.LottoGameValues.LOTTO_SIZE;

class LottoRules {

    private LottoRules() {
    }

    static void eligibleForLotto(List<Integer> inputNums) {
        isLottoSize(inputNums);
        isDuplicated(inputNums);
        isValidNum(inputNums);
    }

    private static void isValidNum(List<Integer> inputNums) {
        for (Integer lottoNum : inputNums) {
            exceptionCheck(lottoNum < LOTTO_NUM_START || lottoNum > LOTTO_NUM_END, "[로또 수 중 범위 내에 있지 않습니다!]");
        }
    }

    private static void isValidNum(int bonusNum) {
        exceptionCheck(bonusNum < LOTTO_NUM_START || bonusNum > LOTTO_NUM_END, "[보너스 수가 범위 내에 있지 않습니다!]");
    }

    private static void isLottoSize(List<Integer> inputNums) {
        exceptionCheck(inputNums.size() != LOTTO_SIZE, "[로또 수가 6개가 아닙니다!]");
    }

    private static void isDuplicated(List<Integer> inputNums) {
        Set<Integer> nums = new HashSet<>(inputNums);
        exceptionCheck(nums.size() != LOTTO_SIZE, "[로또 수 중 중복되는 수가 있습니다.]");
    }

    static void eligibleForWinningLotto(List<Integer> lottoNums, int bonusNum) {
        isBonusDuplicated(lottoNums, bonusNum);
        isValidNum(bonusNum);
    }

    private static void isBonusDuplicated(List<Integer> lottoNums, int bonusNum) {
        for (Integer lottoNum : lottoNums) {
            exceptionCheck(lottoNum == bonusNum, "[보너스 수와 로또 수 중 같은 값이 있습니다!]");
        }
    }

    private static void exceptionCheck(boolean isException, String message) {
        if (isException) {
            throw new IllegalArgumentException(message);
        }
    }
}
