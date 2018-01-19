package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static java.util.stream.Collectors.toList;

public class ManualLottoNumberMaker implements LottoNumberMaker {

  private Stack<List<Integer>> manualNumbers = new Stack<>();

  public void addManualNumber(String inputNumbers) {
    String[] textNumbers = inputNumbers.split(",");
    List<Integer> numbers = Arrays.stream(textNumbers).map(Integer::valueOf).collect(toList());
    manualNumbers.add(numbers);
  }

  public int getManualNumberCnt() {
    return manualNumbers.size();
  }

  @Override
  public List<Integer> issueLottoNumbers() {
    if (manualNumbers.size() < 1) {
      throw new IllegalArgumentException("수동으로 생성된 로또 번호가 없습니다.");
    }
    return manualNumbers.pop();
  }
}
