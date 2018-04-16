package lottogame;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<LottoNo> lottoNos = new ArrayList<>();

    public void add(LottoNo lottoNo) {
        if (isDuplicate(lottoNo)) {
            throw new IllegalArgumentException("각 숫자는 중복되면 안됩니다.");
        }
        lottoNos.add(lottoNo);
    }

    public boolean isDuplicate(LottoNo lottoNo) {
        if (lottoNos.contains(lottoNo)) {
            return true;
        }
        return false;
    }

    public int getMatchCount(Lotto winningLotto) {
        int matchCount = 0;
        for (LottoNo lottoNo : lottoNos) {
            if (winningLotto.contains(lottoNo)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean contains(LottoNo lottoNo) {
        if (lottoNos.contains(lottoNo)) return true;
        return false;
    }

    public boolean matchBonus(LottoNo bonusNumber) {
        if (lottoNos.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public List<LottoNo> getLottoNos() {
        return lottoNos;
    }

    public int getSize() {
        return lottoNos.size();
    }

    @Override
    public String toString() {
        return lottoNos + "";
    }
}