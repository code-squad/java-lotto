import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LearningTest {

    @Test
    public void 음수_텍스트를_int_형_변환해도_예외가_발생하지_않는다() {
        Assertions.assertThat(Integer.parseInt("-10")).isEqualTo(-10);
    }

    @Test
    public void matcher_정해진_정규식에_따라_값을_추출한다() {
        String PATTERNS = "//(.)\n(.*)";
        String text = "//;\\n1;2;3";
        
        Matcher m = Pattern.compile(PATTERNS).matcher(text);

        if (m.find()) {
            Assertions.assertThat(m.group(0)).isEqualTo(PATTERNS);
            Assertions.assertThat(m.group(1)).isEqualTo(";");
            Assertions.assertThat(m.group(2)).isEqualTo("1;2;3");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void matcher_find_를_호출하지_않으면_matcher를_수행하지_않는다() {
        String PATTERNS = "//(.)\n(.*)";
        String text = "//;\\n1;2;3";
        Matcher m = Pattern.compile(PATTERNS).matcher(text);

        Assertions.assertThat(m.group(0)).isEqualTo(PATTERNS);
    }

    @Test
    public void stream_distinct_테스트() {
        //given
        List<Integer> integers = Arrays.asList(1, 1, 2, 3, 4);

        //when
        List<Integer> distinct = integers.stream().distinct().collect(Collectors.toList());

        //then
        Assertions.assertThat(distinct).hasSize(integers.size() - 1);
    }
}
