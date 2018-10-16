package domain;

import dto.LottoBundleDto;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private List<Lotto> theLottoBundle;

    LottoBundle() {
        this.theLottoBundle = new ArrayList<>();
    }

    void add(Lotto aLotto){
        this.theLottoBundle.add(aLotto);
    }

    public LottoBundleDto toDto(){
        LottoBundleDto theLottoBundleDto = new LottoBundleDto();
        for (Lotto theLotto : this.theLottoBundle) {
            theLottoBundleDto.add(theLotto.toDto());
        }
        return theLottoBundleDto;
    }

    public int[] calculateWinStats(Lotto winLotto){
        int[] hitCounts = new int[Lotto.LOTTO_NUMBERS_SIZE + 1];
        for (Lotto theLotto : this.theLottoBundle) {
            hitCounts[theLotto.calculateHitCount(winLotto)]++;
        }
        return hitCounts;
    }

}
