package step0_2;

import static com.google.common.base.Strings.isNullOrEmpty;
import static step0_1.Regex.FLOATING_POINT_REGEX;

import com.google.common.base.CharMatcher;

/**
 * 유효성 확인 class
 */
public class ValidaitonUtil {

  public static String checkBlank(String s) {
    if(isNullOrEmpty(CharMatcher.WHITESPACE.removeFrom(s))){
      throw new IllegalArgumentException("빈 문자열입니다.");
    }
    return s;
  }
  public static String checkDigit(String s) {
    if(!s.matches(FLOATING_POINT_REGEX)){
      throw new RuntimeException("숫자가 아닙니다.");
    }
    return s;
  }

  public static double checkNotNegative(double val) {
    if(val < 0){
      throw new RuntimeException("입력값이 음수입니다.");
    }
    return val;
  }
}
