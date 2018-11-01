package domain;

import domain.Lotto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @Test
    public void checkRankTest() {
        List<Integer> sample1 = new ArrayList<>();
        List<Integer> sample2 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            sample1.add(i);
            sample2.add(i + 2);
        }
        Lotto lotto = new Lotto(sample1);
        Lotto lotto2 = new Lotto(sample2);
        int cnt = lotto.countMatchedNumber(lotto2);
        assertThat(cnt).isEqualTo(4);
    }
}
