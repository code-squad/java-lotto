package lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    LottoMachine lotto;

    @Before
    public void setup() {
        lotto = new LottoMachine();
    }

    @Test
    public void 로또_구매() {
        int result = lotto.getCountOfLotto(13000);
        assertThat(result).isEqualTo(13);
    }

    @Test
    public void test() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        StringBuilder sb = new StringBuilder();
        String result = sb.append("[")
          .append(list
                  .stream()
                  .map(Object::toString)
                  .collect(Collectors.joining(", ")))
          .append("]").toString();
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void test2() {
        String input = "1, 2, 3, 4, 5, 6";
        String[] split = input.split(",| ");
        System.out.println(split[0] + "/");
    }
}
