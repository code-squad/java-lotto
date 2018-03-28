package rank;

import input.Input;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Check {
    Input input = new Input();
    private Lotto right = new Lotto(input.right());

    public Lotto getRight() {
        return right;
    }

    public void checking(List<Lotto> lottos) {
        Input.bonusNumber();
        for(int i = 0; i < lottos.size(); i++) {
            lottos.get(i).checkNumber(right);
        }
    }
}
