package stringAddCalUpgrade;

import static stringAddCalUpgrade.ValidaitonUtil.checkBlank;
import static stringAddCalUpgrade.ValidaitonUtil.checkDigit;
import static stringAddCalUpgrade.ValidaitonUtil.checkNotNegative;

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