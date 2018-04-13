package step0_2;

import static step0_2.ValidaitonUtil.checkBlank;
import static step0_2.ValidaitonUtil.checkDigit;
import static step0_2.ValidaitonUtil.checkNotNegative;

public class Positive {

  double number;

  public Positive(double number) {
    this.number = checkNotNegative(number);
  }

  public Positive(String s) {
    this.number = checkNotNegative(Double.parseDouble(checkBlank(checkDigit(s))));
  }

  public double getNumber() {
    return number;
  }

}