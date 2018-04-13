package step0_1;

import static com.google.common.base.Strings.isNullOrEmpty;
import static step0_1.Regex.FLOATING_POINT_REGEX;

import com.google.common.base.CharMatcher;

/**
 * 유효성 확인 class
 */
public class ValidaitonUtil {
  public static void validatePositive(String s) {
    checkDigit(s);
    checkNotNegative(s);
  }

  static void checkBlank(String s) {
    if(isNullOrEmpty(CharMatcher.WHITESPACE.removeFrom(s))){
      throw new IllegalArgumentException("빈 문자열입니다.");
    }
  }

  static void checkNotNegative(String s) {
    if(Double.parseDouble(s) < 0){
      throw new RuntimeException("입력값이 음수입니다.");
    }
  }

  static void checkDigit(String s) {
    if(!s.matches(FLOATING_POINT_REGEX)){
      throw new RuntimeException("숫자가 아닙니다.");
    }
  }

}
