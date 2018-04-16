package lottoGame.domain;

import java.util.*;

public class Lotto {

    private Set<LottoNo> lottoNumbers;

    public Lotto(Set<LottoNo> lottoNums) {
        this.lottoNumbers = vaildLottoSize(lottoNums);
    }

    public Lotto(List<LottoNo> lottoNums) {
        this.lottoNumbers = vaildLottoSize(new HashSet<>(lottoNums));
    }

    public Lotto(int... lottoNums) {
        lottoNumbers = new HashSet<>();
        for(int lottoNum:lottoNums) {
            lottoNumbers.add(new LottoNo(lottoNum));
        }
        vaildLottoSize(lottoNumbers);
    }

    public Set<LottoNo> getLottoNums() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    public boolean isContainLottoNum(LottoNo lottoNum) {
        return lottoNumbers.contains(lottoNum);
    }

    public boolean isContainBonusNum(LottoNo bonusNum) {
        return lottoNumbers.contains(bonusNum);
    }

    private List<LottoNo> getSortedList() {
        List<LottoNo> lottoSortedNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(lottoSortedNumbers);
        return lottoSortedNumbers;
    }

    private Set<LottoNo> vaildLottoSize(Set<LottoNo> lottoNums) {
        if(lottoNums.size() != 6) {
            throw new IllegalArgumentException();
        }
        return lottoNums;
    }

    @Override
    public String toString() {
        return getSortedList().toString();
    }
}
