package domain;

import dto.LottoBundleDto;
import vo.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private List<Lotto> multiLotto;

    LottoBundle() {
        this.multiLotto = new ArrayList<>();
    }

    private LottoBundle(List<Lotto> multiLotto) {
        this.multiLotto = multiLotto;
    }

    void add(Lotto aLotto){
        this.multiLotto.add(aLotto);
    }

    public LottoBundle addAll(LottoBundle otherLottoBundle){
        return otherLottoBundle.addAll(this.multiLotto);
    }

    LottoBundle addAll(List<Lotto> multiLotto){
        multiLotto.addAll(this.multiLotto);
        return new LottoBundle(multiLotto);
    }

    public LottoBundleDto toDto(){
        LottoBundleDto theLottoBundleDto = new LottoBundleDto();
        for (Lotto aLotto : multiLotto) {
            theLottoBundleDto.add(aLotto.toDto());
        }
        return theLottoBundleDto;
    }

    public WinStats calculateWinStats(WinningLotto theWinningLotto, Money investedMoney) {
        WinStats theWinStats = new WinStats();
        for (Lotto aLotto : this.multiLotto) {
            Rank rank = Rank.valueOf(theWinningLotto.calculateHitCount(aLotto), theWinningLotto.isHitBonusBall(aLotto));
            theWinStats.countRank(rank);
        }
        theWinStats.calculateEarningRate(investedMoney);
        return theWinStats;
    }

    Lotto getALotto(int index) {
        return this.multiLotto.get(index);
    }
}
