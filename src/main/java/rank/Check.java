package rank;

import input.Input;
import lotto.Lotto;

import java.util.List;

public class Check {
    Input input = new Input();
    private Lotto winningNumber = new Lotto(input.right());

    public Lotto getRight() {
        return winningNumber;
    }

    public void checking(List<Lotto> lottos) {
        Input.bonusNumber();
        for(int i = 0; i < lottos.size(); i++) {
            lottos.get(i).checkNumber(winningNumber);
        }
    }
}
