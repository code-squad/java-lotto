package lottogame;

import lottogame.util.LottoUtils;
import lottogame.util.MyStringUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by hongjong-wan on 2018. 4. 8..
 */
public class WinningLotto {

    private Lotto winningLotto;
    private LottoNo bonusNumber;

    public WinningLotto(String text) {
        if (StringUtils.isBlank(text)) {
            throw new IllegalArgumentException("지난 주 당첨번호를 입력해주세요.");
        }
        this.winningLotto = LottoUtils.createLotto(MyStringUtils.split(text));

    }

    public void addBonusNumber(LottoNo bonusNumber) {
        if (winningLotto.isDuplicate(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호 6개 값이아니어야 합니다.");
        }
        this.bonusNumber = bonusNumber;
    }

    public int getMatchCount(Lotto lotto) {
        return lotto.getMatchCount(winningLotto);
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.matchBonus(bonusNumber);
    }

}