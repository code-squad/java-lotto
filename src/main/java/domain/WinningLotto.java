package domain;

import dto.LottoDto;
import dto.LottoDtos;
import dto.WinResultDto;
import vo.No;
import vo.Rank;

import java.util.Random;

public class WinningLotto {
    private Lotto winLotto;
    private No bonusNum;

    public WinningLotto(Lotto winLotto, No bonusNum) {
        this.winLotto = winLotto;
        this.bonusNum = checkWinningBonus(winLotto, bonusNum);
    }

    private No checkWinningBonus(Lotto winLotto, No bonusNum) {
        if (winLotto.checkBonusNum(bonusNum))
            throw new IllegalArgumentException("Bonus 번호는 로또번호와 같을 수 없습니다.");
        return bonusNum;
    }

    public Rank compareWinLottoNum(Lotto lotto) {
        return findMatchRank(this.winLotto.compareLottoNumbs(lotto), lotto.checkBonusNum(this.bonusNum));
    }

    private static Rank findMatchRank(int matchNumAmt, Boolean matchBonums) {
        for (Rank rank : Rank.values()) {
            if (matchNumAmt == Rank.SECOND.getMatchNumAmt())
                return matchBonums ? Rank.SECOND : Rank.THIRD;
            if (matchNumAmt == rank.getMatchNumAmt()) return rank;
        }
        return Rank.NONE;
    }

    public WinResultDto checkWins(LottoDtos lottos) throws Exception {
        WinResultDto resultDto = WinResultDto.init();
        for (LottoDto lottoDto : lottos.getLottoDtos()) {
            resultDto.setRankAmt(compareWinLottoNum(Lotto.initArtifitial(lottoDto.getLottoDto())));
        }
        return resultDto;
    }

}
