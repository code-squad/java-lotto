package domain;

import util.Constants;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RandomLottoNumberMaker implements LottoNumberMaker {

  @Override
  public List<Integer> issueLottoNumbers() {
    List<Integer> randoms = IntStream.iterate(1, n -> n + 1).boxed().limit(Constants.MAX_NUMBER).collect(toList());
    Collections.shuffle(randoms);
    return randoms.stream()
        .limit(Constants.NUMBER_SIZE)
        .sorted()
        .collect(toList());
  }
}
