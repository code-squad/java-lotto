package Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private int manualCount;
    private Money money;

    private List<Lotto> userLottoNumbers;

    public LottoGame(Money money, List<Lotto> manualLottoNumbers) {
        this.manualCount = manualLottoNumbers.size();
        this.money = money;

        userLottoNumbers = new ArrayList<>();
        userLottoNumbers.addAll(manualLottoNumbers);
        for (int i = 0; i < getAutoCount(); i++) {
            userLottoNumbers.add(Lotto.makeLottoNumber());
        }
    }

    public int getAutoCount() {
        return money.purchasedLottoNumber() - this.manualCount;
    }

    public int getManualCount() {
        return this.manualCount;
    }

    public int getTotalCount() {
        return this.userLottoNumbers.size();
    }

    public String getUserLottoNumber(int i) {
        return this.userLottoNumbers.get(i).toString();
    }

    public LottoGameResult playLottoGame(Lotto winningLottoNumber, int bonus) {
        LottoGameResult lottoGameResult = new LottoGameResult();

        for (Lotto userLottoNumber : userLottoNumbers) {
            LottoGameResult.setPrizeCount(Rank.valueOf(winningLottoNumber.countMatchLottoNumber(userLottoNumber), userLottoNumber.isContainsBonusNumber(bonus)));
        }

        return lottoGameResult;
    }

}