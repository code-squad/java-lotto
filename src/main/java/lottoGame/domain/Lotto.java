package lottoGame.domain;

import java.util.*;

public class Lotto {

    private Set<Integer> lottoNumbers;

    public Lotto(Set<Integer> lottoNums) {
        this.lottoNumbers = lottoNums;
    }

    public Lotto(List<Integer> lottoNums) {
        this.lottoNumbers = new HashSet<>(lottoNums);
    }

    public Set<Integer> getLottoNums() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    public boolean isContainLuckyNum(int lottoNum) {
        return lottoNumbers.contains(lottoNum);
    }

    public boolean isContainBonusNum(int bonusNum) {
        return lottoNumbers.contains(bonusNum);
    }

    private List<Integer> getSortedList() {
        List<Integer> lottoSortedNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(lottoSortedNumbers);
        return lottoSortedNumbers;
    }

    private int addContainLuckyNum(int cnt, int luckyNum) {
        if(isContainLuckyNum(luckyNum)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return getSortedList().toString();
    }
}
