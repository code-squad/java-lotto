package lotttoOlder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotttoOlder.utility.Parser;

public class Lotto implements Match {

  private List<Integer> actualNums;
  private List<Integer> lottoNumPool = IntStream
      .rangeClosed(LottoInfo.LOTTO_NUM_START, LottoInfo.LOTTO_NUM_END)
      .boxed()
      .collect(Collectors.toCollection(ArrayList::new));

  public Lotto() {
    Collections.shuffle(lottoNumPool);
    this.actualNums = new ArrayList<>(lottoNumPool.subList(0, LottoInfo.LOTTO_NUM_COUNT));
  }

  public Lotto(List<Integer> input) {
//    TODO 생성자 만들때 유효성 검사해도 됨?
    Parser parser = new Parser();
    parser.validateLottoNums(input);
    parser.validateLottoNumCount(input);

    this.actualNums = input;
  }

  public Lotto(String s) {
    this.actualNums = new Parser().splitor(s);
  }

  private List<Integer> getActualNums() {
    return actualNums;
  }

  //  TODO interface 고치기 - 인터페이스 써보고 싶은데 제대로 못쓰고 있음
  @Override
  public int countSameNumber(Lotto jackpot) {
    List<Integer> notSameNum = actualNums;
    notSameNum.removeAll(jackpot.getActualNums());

    return LottoInfo.LOTTO_NUM_COUNT - notSameNum.size();
  }

  public String showNum(String delimiter) {
    return actualNums.stream().map(Object::toString)
        .collect(Collectors.joining(delimiter));
  }
}
