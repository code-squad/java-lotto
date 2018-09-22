package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Lotto {

    private Set<LottoNo> lotto;

    public Lotto(String paramLottoNumbers) {
        lotto = new HashSet<>();
        String[] lottoNumbers = paramLottoNumbers.split(",");

        checkParameterCount(lottoNumbers);
        for (String paramLottoNo : lottoNumbers) {
            LottoNo lottoNo = new LottoNo(Integer.parseInt(paramLottoNo.trim()));
            checkNumberDuplication(lottoNo);
            lotto.add(lottoNo);
        }
    }

    private void checkParameterCount(String[] lottoNumbers) {
        if (lottoNumbers.length != 6) {
            throw new IllegalArgumentException("숫자가 6개만 입력이 되어야 합니다.");
        }
    }

    public void checkNumberDuplication(LottoNo lottoNo) {
        if (lotto.contains(lottoNo)) {
            throw new IllegalArgumentException("번호가 중복되었습니다.");
        }
    }

    public Set<LottoNo> getLotto() {
        Set<LottoNo> unModifiableLotto = Collections.unmodifiableSet(lotto);
        return unModifiableLotto;
    }

    public int getMatchCount(WinLotto winLotto) {
        int winCount = 0;

        for (LottoNo winNumber : winLotto.getWinLotto().getLotto()) {
            if (lotto.contains(winNumber)) {
                winCount++;
            }
        }
        return winCount;
    }


    public Rank calculateRank(WinLotto winLotto) {
        return Rank.valueOf(getMatchCount(winLotto), lotto.contains(winLotto.getBonusNumber()));
    }


    public boolean contains(LottoNo number) {
        return lotto.contains(number);
    }

    @Override
    public String toString() {
        String[] lottoNumbers = new String[lotto.size()];
        Iterator<LottoNo> iterator = lotto.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            lottoNumbers[i++] = iterator.next().getLottoNo() + "";
        }

        return "[" + String.join(",", lottoNumbers) + "]";
    }
}
