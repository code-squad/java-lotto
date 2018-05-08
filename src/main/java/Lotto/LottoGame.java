package Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private int manualCount;
    private int money;

    private List<Lotto> userLottoNumbers;

    public LottoGame(int money, List<Lotto> manualLottoNumbers) {
        this.manualCount = manualLottoNumbers.size();
        this.money = money;

        userLottoNumbers = new ArrayList<>();
        userLottoNumbers.addAll(manualLottoNumbers);
        for (int i = 0; i < getAutoCount(); i++) {
            userLottoNumbers.add(Lotto.makeLottoNumber());
        }
    }

    public int getAutoCount() {
        return (this.money / 1000) - this.manualCount;
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

    public LottoGameResult playLottoGame(List<String> winningNumber, int bonus) {
        LottoGameResult lottoGameResult = new LottoGameResult();

        Lotto winningLottoNumber = Lotto.makeManualLottoNumber(winningNumber);
        winningLottoNumber.checkBonusNumber(bonus);

        for (Lotto userLottoNumber : userLottoNumbers) {
            LottoGameResult.setPrizeCount(Rank.valueOf(winningLottoNumber.contains(userLottoNumber), userLottoNumber.makeBonusNumber(bonus)));
        }

        return lottoGameResult;
    }

}