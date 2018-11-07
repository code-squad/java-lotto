package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosFactoryTest {

    @Test
    public void makeLottos() {
        Lottos lottos = LottosFactory.makeLottos(14);
        assertThat(lottos.getSize()).isEqualTo(14);
    }
}
