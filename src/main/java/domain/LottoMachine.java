package domain;

import dto.LottoResult;
import util.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class LottoMachine {

  private List<Lotto> lottos;
  private LottoNumberMaker lottoNumberMaker;

  public LottoMachine() {
    this.lottos = new ArrayList<>();
  }

  public void setLottoNumberMaker(LottoNumberMaker lottoNumberMaker) {
    this.lottoNumberMaker = lottoNumberMaker;
  }

  public int getLottoCount(int money) {
    return money / Constants.PRICE_PER_LOTTO_ONE_GAME;
  }

  public List<Lotto> issue(int count) {
    IntStream.rangeClosed(1, count)
        .forEach(i -> add(new Lotto(lottoNumberMaker.issueLottoNumbers())));
    return lottos;
  }

  public void add(Lotto lotto) {
    this.lottos.add(lotto);
  }

  public static WinningLotto createWinningLotto(String strNumbers, int bonusNumber) {
    String[] numbers = strNumbers.split(",");
    List<Integer> winningNumbers = Arrays.stream(numbers)
        .map(n -> Integer.parseInt(n))
        .collect(toList());
    return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
  }

  public LottoResult match(WinningLotto winningLotto) {
    LottoResult result = new LottoResult();
    Map<String, Long> rankOfCountData = getRankOfCount(winningLotto);
    rankOfCountData.keySet().stream().forEach(name -> {
      result.add(Rank.valueOf(name), rankOfCountData.get(name).intValue());
    });
    return result;
  }

  public Map<String, Long> getRankOfCount(WinningLotto winningLotto) {
    return lottos.stream().map(l -> l.match(winningLotto))
        .collect(groupingBy(Rank::name, counting()));
  }
}
