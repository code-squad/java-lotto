package domain;

import java.util.List;

public class WinningLotto extends Lotto{

    private LottoNumber bonusNumber;
//    private int bonusNumber;

    public WinningLotto(List<Integer> lotto, int bonusNumber) {
        super(lotto);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public boolean hasBonus(List<LottoNumber> userNumbers) {

        if(userNumbers.contains(bonusNumber)){
            return true;
        }
        return false;
    }
}
