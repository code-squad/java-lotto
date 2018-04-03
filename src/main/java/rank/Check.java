package rank;

import input.InputUI;
import lotto.Lotto;

import java.util.List;

public class Check {
    InputUI inputUI = new InputUI();
    private Lotto winningNumber = new Lotto(inputUI.right());

    public Lotto getRight() {
        return winningNumber;
    }

    public void checking(List<Lotto> lottos) {
        InputUI.bonusNumber();
        for(int i = 0; i < lottos.size(); i++) {
            lottos.get(i).checkNumber(winningNumber);
        }
    }
}
