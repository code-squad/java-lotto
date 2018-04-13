package step0_2;

import static step0_1.Regex.CUSTOM_DELIMITER_REGEX;
import static step0_1.Regex.DEFAULT_DELIMITER_REGEX;
import static step0_1.Regex.WITH_CUSTOM_DELIMITER_REGEX;
import static step0_1.Regex.WITH_DEFAULT_DELIMITER_REGEX;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 입력문자열 파싱하는 class
 * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열 또는 커스컴 구분자를 포함한 문자열을 입력받음
 * 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
 * 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
 * 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)
 *
 */
public class Parser {

//  TODO idea! interface로 하면 타입 바뀌어도 편할까?

  public List<Positive> doSplit(String input){
    List<Positive> positives = new ArrayList<>();

    for(String num : getPlainInput(input).split(getDelim(input))){
      positives.add(new Positive(num));
    }
    return positives;
  }

  String getPlainInput(String input) {
    Matcher m = Pattern.compile(WITH_CUSTOM_DELIMITER_REGEX).matcher(input);
    if(m.find()){
      return m.group(2);
    }
    return input;
  }

  String getDelim(String input) {
    if(input.matches(WITH_DEFAULT_DELIMITER_REGEX)){
      return DEFAULT_DELIMITER_REGEX;
    }else if(input.matches(WITH_CUSTOM_DELIMITER_REGEX)){
      return validateDelim(getPlainInput(input),getCustomDelim(input));
    }
    throw new IllegalArgumentException("기본 구분자가 아니고, 커스텀구분자 정의가 없는 잘못된 구분자입니다");
  }

  String getCustomDelim(String input) {
    Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
    if (m.find()){
      return m.group(1);
    }
    return null;
  }

  String validateDelim(String plainText, String delim) {
    ValidaitonUtil.checkBlank(delim);
    if (!DEFAULT_DELIMITER_REGEX.equals(delim) && !plainText.contains(delim)) {
      throw new IllegalArgumentException("정의돤 구분자와 실제 데이터의 구분자가 다릅니다.");
    }
    return delim;
  }
}
