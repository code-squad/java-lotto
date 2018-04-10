package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sangsik.kim
 */
public class StringUtilTest {

    @Test
    public void 커스텀_구분자_추출() {
        String separator = StringUtil.getSeparator("//*\n");
        assertThat(separator).isEqualTo("*");
    }

    @Test
    public void 커스텀_구분자가_존재하지_않을때() {
        String separator = StringUtil.getSeparator("1:2;3");
        assertThat(separator).isEqualTo(",|:");
    }

    @Test
    public void 구분자_제외한_문자열_추출() {
        String text = StringUtil.getTextWithoutSeparator("//@\n1");
        assertThat(text).isEqualTo("1");
    }
}
