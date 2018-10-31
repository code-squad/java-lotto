package domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosFactoryTest {

    @Test
    public void makeLottos() {
        List<Lotto> lottos = LottosFactory.makeLottos(14);
        assertThat(lottos.size()).isEqualTo(14);
    }
}
