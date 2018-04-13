package calculator;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomSplitterTest {
    @Test
    public void 서포트확인() {
        Splitter splitter = new CustomSplitter(",");
        String commaContain = "1,2,3";
        assertThat(splitter.supports(commaContain)).isEqualTo(true);
    }

    @Test
    public void 서포트false확인() {
        Splitter splitter = new CustomSplitter(",");
        String commaContain = "1;2;3";
        assertThat(splitter.supports(commaContain)).isEqualTo(true);
    }

    @Test
    public void 스플릿확인() {
        Splitter splitter = new CustomSplitter(",");
        String commaContain = "1,2,3";
        String[] splitResult =splitter.split(commaContain);
        String[] expectResult = {"1", "2", "3"};

        assertThat(splitResult).isEqualTo(expectResult);

    }
}
