package LottoGame;

import LottoGameUtil.LottoUtils;
import LottoGameUtil.MyStringUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by hongjong-wan on 2018. 4. 8..
 */
public class WinningLotto {

    private LottoNos winningLottoNos;
    private LottoNo bonusNumber;

    public WinningLotto(String text, LottoNo bonusNumber) {
        if(StringUtils.isBlank(text)) {
            throw new IllegalArgumentException("당첨번호를 공백으로 입력하셨습니다.");
        }
        this.winningLottoNos = LottoUtils.createLotto(MyStringUtils.split(text));
        if (winningLottoNos.isDuplicate(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호 6개 값이아니어야 합니다.");
        }
        this.bonusNumber = bonusNumber;
    }


    public int getMatchCount(LottoNos lottoNos) {
        return lottoNos.getMatchCount(winningLottoNos);
    }

    public boolean matchBonus(LottoNos lottoNos) {
        return lottoNos.matchBonus(bonusNumber);
    }
}