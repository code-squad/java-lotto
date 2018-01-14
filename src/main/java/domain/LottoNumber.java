package domain;

import java.util.Objects;

public class LottoNumber {

  private int number;

  public LottoNumber(int number) {
    if (number < 1 || number > 45) {
      throw new IllegalArgumentException("numbers from 1 to 45 are valid");
    }
    this.number = number;
  }

  public boolean isWinningNumber(int number) {
    return this.number == number;
  }

  public int getNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LottoNumber)) {
      return false;
    }
    LottoNumber that = (LottoNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }
}
