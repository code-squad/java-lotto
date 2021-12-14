package generator;

import domain.Lotto;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoGeneratorTest {
    @Test
    public void 자동로또생성() {
        //given
        int autoSize = 10;
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator(autoSize);

        //when
        List<Lotto> lottos = autoLottoGenerator.generateLotto();

        //then
        assertThat(lottos.size()).isEqualTo(autoSize);
    }
}