package lotttoOlder.utility;

import com.google.common.primitives.Ints;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotttoOlder.InputInfo;
import lotttoOlder.LottoInfo;

public class Parser {

  public List<Integer> splitor(String s) {
    return Ints.asList(
        Arrays.stream(validateLottoNums(s.split(InputInfo.DELIMINTER))).mapToInt(Integer::parseInt)
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

  public void validateLottoNumCount(List<Integer> input) {
    if (input.size() != LottoInfo.LOTTO_NUM_COUNT) {
      throw new IllegalArgumentException("입력받은 로또숫자는 6개가 아닙니다.");
    }
  }

  private int validateLottoRange(int i) {
    if (i < LottoInfo.LOTTO_NUM_START || i > LottoInfo.LOTTO_NUM_END) {
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

  public static String validateDigit(String s) {
    if (!s.matches("(\\d)+")) {
      throw new IllegalArgumentException("숫자가 아닙니다.");
    }
    return s;
  }
}

