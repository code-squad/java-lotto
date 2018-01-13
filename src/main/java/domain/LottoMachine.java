package domain;

import java.util.ArrayList;
import java.util.List;
import util.RandomGenerator;

public class LottoMachine {

  private static final int PRICE_PER_LOTTO_ONE_GAME = 1000;
  private List<Lotto> lottos;

  public LottoMachine() {
    this.lottos = new ArrayList<>();
  }

  public int getLottoCount(int money) {
    return money / PRICE_PER_LOTTO_ONE_GAME;
  }

  public List<Lotto> issue(int count) {
    for (int i = 0; i < count; i++) {
      Lotto lotto = new Lotto(RandomGenerator.generateNumber());
      lottos.add(lotto);
    }
    return lottos;
  }
}
