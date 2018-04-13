package step0_2;

import java.util.List;

/**
 * 입력값, delim, numbers
 */
public class Input {

  private List<Positive> positive;
  private String input;

  public Input(String input) {
    Parser parser = new Parser();

    this.input = ValidaitonUtil.checkBlank(input);
    this.positive = parser.doSplit(input);
  }

  public List<Positive> getPositive() {
    return positive;
  }
}
