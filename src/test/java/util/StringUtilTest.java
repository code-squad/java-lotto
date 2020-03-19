package util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @Test
    public void 숫자String배열을_Integer리스트로_변환() {
        //given
        String[] array = {"1", "2", "3", "4", "5", "6"};
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        List<Integer> result = StringUtil.convertToInt(array);

        //then
        assertThat(list).isEqualTo(result);
    }
}