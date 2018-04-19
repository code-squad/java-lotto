package Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private int count;
    private int money;

    private List<Lotto> userLottoNumbers;

    public LottoGame(int money) {
        this.count = money / 1000;
        this.money = money;

        userLottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            userLottoNumbers.add(Lotto.makeLottoNumber());
        }
    }

    public int getCount() {
        return this.count;
    }

    public String getUserLottoNumber(int i) {
        return this.userLottoNumbers.get(i).toString();
    }

    public LottoGameResult playLottoGame(List<String> winningNumber, int bonus) {
        LottoGameResult lottoGameResult = new LottoGameResult();

        Lotto winningLottoNumber = Lotto.makeWinningNumber(winningNumber);
        winningLottoNumber.checkBonusNumber(bonus);

        for (Lotto userLottoNumber : userLottoNumbers) {
            LottoGameResult.setPrizeCount(Rank.valueOf(winningLottoNumber.contains(userLottoNumber), userLottoNumber.makeBonusNumber(bonus)));
        }

        return lottoGameResult;
    }

}