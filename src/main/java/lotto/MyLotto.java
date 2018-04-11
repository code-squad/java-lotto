package lotto;

import java.util.ArrayList;
import java.util.List;

public class MyLotto {
    private int countOfLotto;
    private List<Integer>[] lottos;

    public MyLotto(int countOfLotto) {
        this.countOfLotto = countOfLotto;
        lottos = new ArrayList[countOfLotto];
        initLottos();
    }

    public List<Integer> purchaseLotto(int position) {
        lottos[position] = LottoMachine.getLottoNumber();
        return lottos[position];
    }

    public List<Integer>[] getLottos() {
        return lottos;
    }

    public String toStringLotto(int position) {
        StringBuilder sb = new StringBuilder();
        return null;
    }

    private void initLottos() {
        for (int index = 0; index < countOfLotto; index++) {
            lottos[index] = new ArrayList<>();
        }
    }
}
