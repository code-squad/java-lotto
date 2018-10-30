package domain;

import vo.LottoNoFactory;

import java.util.Set;

public class WinningLottoFactory {
    public static WinningLotto generateWinningLotto(Set<Integer> numbers, int bonusNumber){
        return new WinningLotto(LottoNoFactory.getMultiLottoNo(numbers), LottoNoFactory.getLottoNo(bonusNumber));
    }
}
