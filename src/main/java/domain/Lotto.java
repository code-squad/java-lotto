package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int MAX = 45;
    private static final int MIN = 1;

    private List<Integer> lotto;

    // 생성자 내에서 유효성을 체크하는 것이 더 좋다.
    // List는 순서를 보장하고 Set은 중복제거를 보장한다.

    private Lotto(List<Integer> lotto) {
        lottoSizeCheck(lotto.size());
        lottoNumbCheck(lotto);
        duplicateNumCheck(lotto);
        this.lotto = lotto;
    }

    private static Lotto of(List<Integer> manualLotto) {
        return new Lotto(manualLotto);
    }

    public static Lotto of(String manualLotto) {
        return of(Parser.parsing(manualLotto));
    }

    private void lottoSizeCheck(int num) {
        if (num != LOTTO_SIZE) {
            throw new RuntimeException("로또 한 장은 6개의 번호여야 한다.");
        }
    }

    private void lottoNumbCheck(List<Integer> lotto) {
        for (Integer num : lotto) {
            if (num > MAX || num < MIN) {
                throw new RuntimeException("로또의 숫자는 1 ~ 45 사이의 값이어야 합니다.");
            }
        }
    }

    private void duplicateNumCheck(List<Integer> lotto) {
        Set<Integer> checker = new HashSet<>();
        for (Integer num : lotto) {
            if (checker.contains(num)) throw new RuntimeException("중복되는 숫자가 있습니다.");
            checker.add(num);
        }
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public static Lotto buyingLottos() {
        return new Lotto(LottoNumGenerator.createLotto());
    }

    public Rank matchedLotto(WinningNum winningNum) {
        List<Integer> winningLotto = winningNum.getPreWinNums();
        int count = 0;
        boolean checkBonusBall = false;
        for (Integer num : winningLotto) {
            count = countMatchedNumbs(num, count);
        }
        //winningNum.matchCount(lotto);
        //굳이 모든 for문에서 처리할 필요가 있나?
        //for문이 끝난 후 마지막에 한번 확인하면 되지 않을까?
        checkBonusBall = checkForBonusBall(winningNum.getBonusBall());
        return Rank.valueOf(count, checkBonusBall);
    }

    private int countMatchedNumbs(int num, int count) {
        if (lotto.contains(num)) {
            return ++count;
        }
        return count;
    }

    private boolean checkForBonusBall(int bonusBall) {
        return lotto.contains(bonusBall);
    }
}
