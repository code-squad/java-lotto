package lotto.util;

import org.junit.Test;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SplitUtilTest {

    private static final String a = "1,2,3,4,5,6";

    @Test
    public void prizeSplit() {
//        assertThat(SplitUtil.prizeSplit(Main).length).isEqualTo(6);
    }

    @Test
    public void prizeBlankRemoval() {
        String a = "   1, 3,5,  7,9";
        String b = "1,3,5,7,9";
//        assertThat(SplitUtil.prizeBlankRemoval(Main)).isEqualTo(b);
    }

    @Test
    public void prizeList() {
        List<Integer> list = SplitUtil.prizeList(a);
        for (int i = 0; i < 6; i++) {
            assertThat(list.get(i) instanceof Integer).isTrue();
//            타입 비교하는 것 instanceof => 타입을 추론하는 것.
            assertThat(list.get(i)).isEqualTo(i + 1);
        }
    }
}