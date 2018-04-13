package step0_1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PaserTest {

  Parser paser = null;

  @Before
  public void setUp() {
    paser = new Parser();
  }

  @Test
  public void 문자열_입력했을때_쉼표_구분자로_구분하여_리턴하는지_확인() {
    assertThat(paser.doSplit("3,4")).isEqualTo(new String[]{"3", "4"});
  }

  @Test
  public void 문자열_입력했을때_콜론_구분자로_구분하여_리턴하는지_확인() {
    assertThat(paser.doSplit("3:4")).isEqualTo(new String[]{"3", "4"});
  }

  @Test
  public void 문자열_입력했을때_커스텀_구분자로_구분하여_리턴하는지_확인() {
    assertThat(paser.doSplit("//;\n3;4")).isEqualTo(new String[]{"3", "4"});
  }

  @Test(expected = RuntimeException.class)
  public void 구분자정의와_실제_문자열구분자와_일치하지_않을때_Exception_던지는지_확인() {
    paser.doSplit("//;\n3?2");
  }

  @Test(expected = IllegalArgumentException.class)
  public void 구분자정의와_실제_문자열구분자_일치하지_않고_실제구분자가_기본구분자일때_Exception_던지는지_확인() {
    paser.doSplit("//;\n3:2");
  }

  @Test
  public void 커스텀_구분자를_가져오는지_확인() {
    assertThat(paser.getDelim("//;\n3;4")).isEqualTo(";");
  }

  @Test(expected = IllegalArgumentException.class)
  public void 기본_구분자가_아니고_커스텀_구분자정의가_없을때_Exception_던지는지_확인() {
    paser.getDelim("3;4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void 커스텀구분자정의가_없고_기본구분자도_아닐때_IllegalArgumentException_던지는지_확인() {
    paser.getDelim("3?2");
  }

  @Test
  public void 기본_구분자_콜론_정규식을_가져오는지_확인() {
    assertThat(paser.getDelim("3:4")).isEqualTo(",|:");
  }

  @Test
  public void 기본_구분자_쉼표_정규식을_가져오는지_확인() {
    assertThat(paser.getDelim("3:4")).isEqualTo(",|:");
  }

  @Test
  public void 구분자정의있을때_구분자정의없는_문자열만_가져오는지_확인() {
    assertThat(paser.getPlainInput("//;\n3;4")).isEqualTo("3;4");
  }

  @Test
  public void 구분자정의없을때_문자열만_가져오는지_확인() {
    assertThat(paser.getPlainInput("3:4")).isEqualTo("3:4");
  }
}
