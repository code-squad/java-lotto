package domain;

import java.util.List;

public class WinningLotto extends Lotto{

    int bonusNumber;
    public WinningLotto(List<Integer> lotto, int bonusNumber) {
        super(lotto);
        this.bonusNumber = bonusNumber;
    }

    public boolean bonusMatch(List<Integer> userNumbers) {
        if(userNumbers.contains(bonusNumber)){
            return true;
        }
        return false;
    }
}
