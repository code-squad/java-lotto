package lotttoOlder;

import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

  private List<Integer> nums;
  //  private static final List<Integer> lottoNum = IntStream.rangeClosed(Rule.LOTTO_NUM_START, Rule.LOTTO_NUM_END).boxed()
//      .collect(Collectors.toCollection(ArrayList::new));
  private List<Integer> lottoNum = IntStream.rangeClosed(Rule.LOTTO_NUM_START, Rule.LOTTO_NUM_END)
      .boxed()
      .collect(Collectors.toCollection(ArrayList::new));

  public Lotto() {
    Collections.shuffle(lottoNum);
    this.nums = new ArrayList<>(lottoNum.subList(0, Rule.LOTTO_NUM_COUNT - 1));
  }

  public Lotto(List<Integer> input) {
    Parser parser = new Parser();
    parser.validateLottoNums(input);
    parser.validateLottoNumCount(input);

    this.nums = input;
  }

  public Lotto(String s) {
    this.nums = new Parser().splitor(s);
  }

  private List<Integer> getNums() {
    return nums;
  }

  public int countSameNum(Lotto jackpot) {
    List<Integer> notSameNum = nums;
    notSameNum.removeAll(jackpot.getNums());

    return Rule.LOTTO_NUM_COUNT - notSameNum.size();
  }

  public int countSame(Lotto jackpot) {
    int count = 0;
    return count += isSame(jackpot);
  }

  private int isSame(Lotto jackpot) {
    return nums.contains(jackpot)? 1 : 0;
  }

  static class Rule {
    private static final String DELIMINTER = ",";
    private static final int LOTTO_NUM_COUNT = 6;
    private static final int LOTTO_NUM_START = 1;
    private static final int LOTTO_NUM_END = 45;
  }

  class Parser {

    public List<Integer> splitor(String s) {
      return Ints.asList(
          Arrays.stream(validateLottoNums(s.split(Rule.DELIMINTER))).mapToInt(Integer::parseInt)
              .toArray());
    }

    public List<Integer> validateLottoNums(List<Integer> inputs) {
      for (int i : inputs) {
        validateLottoRange(i);
      }
      return validateDuplicateVal(inputs);
    }

    public String[] validateLottoNums(String[] inputs) {
      for (String s : inputs) {
        validateDigit(s);
        validateLottoRange(Integer.parseInt(s));
      }
      validateDuplicateVal(inputs);

      return inputs;
    }

    private void validateLottoNumCount(List<Integer> input) {
      if (input.size() != Rule.LOTTO_NUM_COUNT) {
        throw new IllegalArgumentException("입력받은 로또숫자는 6개가 아닙니다.");
      }
    }

    private int validateLottoRange(int i) {
      if (i < Rule.LOTTO_NUM_START || i > Rule.LOTTO_NUM_END) {
        throw new IllegalArgumentException("로또 숫자 범위를 벗어납니다.(숫자범위: 1~45)");
      }
      return i;
    }

    private List<Integer> validateDuplicateVal(List<Integer> inputs) {
      Set<Integer> removedDuplicateVal = new HashSet<Integer>(inputs);

      if (removedDuplicateVal.size() != inputs.size()) {
        throw new IllegalArgumentException("입력값 중에 중복값이 존재합니다.");
      }
      return inputs;
    }

    private String[] validateDuplicateVal(String[] inputs) {
      Set<String> removedDuplicateVal = new HashSet<>(Arrays.asList(inputs));

      if (removedDuplicateVal.size() != inputs.length) {
        throw new IllegalArgumentException("입력값 중에 중복값이 존재합니다.");
      }
      return inputs;
    }

    public String validateDigit(String s) {
      if (!s.matches("(\\d)+")) {
        throw new IllegalArgumentException("숫자가 아닙니다.");
      }
      return s;
    }
  }


}
