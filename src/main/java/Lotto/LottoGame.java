package Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private int autoCount;
    private int manualCount;
    private int totalCount;
    private int money;

    private List<Lotto> userLottoNumbers;

    public LottoGame(int money, List<Lotto> manualLottoNumbers) {
        this.manualCount = manualLottoNumbers.size();
        this.autoCount = (money / 1000) - manualCount;
        this.totalCount = autoCount + manualCount;
        this.money = money;

        userLottoNumbers = new ArrayList<>();
        userLottoNumbers.addAll(manualLottoNumbers);
        for (int i = 0; i < autoCount; i++) {
            userLottoNumbers.add(Lotto.makeLottoNumber());
        }
    }

    public int getAutoCount() {
        return this.autoCount;
    }

    public int getManualCount() {
        return this.manualCount;
    }

    public int getTotalCount() {
        return this.totalCount;
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