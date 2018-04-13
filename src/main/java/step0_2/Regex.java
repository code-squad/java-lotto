package step0_2;

/**
 * 정규표현식 모음 class
 */
public class Regex {
  public static final String FLOATING_POINT_REGEX = "(\\d)*(\\.)?(\\d)+";

  public static final String CUSTOM_DELIMITER_REGEX = "//(.*)\n";
  public static final String WITH_CUSTOM_DELIMITER_REGEX = CUSTOM_DELIMITER_REGEX + "(.*)";
  public static final String DEFAULT_DELIMITER_REGEX = ",|:";
  public static final String WITH_DEFAULT_DELIMITER_REGEX = "((.*)("+DEFAULT_DELIMITER_REGEX+"))+(.*)";
}
