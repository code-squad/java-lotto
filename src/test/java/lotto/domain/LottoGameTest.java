package lotto.domain;

import lotto.domain.dto.LottoDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @Test
    public void 생성자() {
        LottoGame lg = new LottoGame(2000);
        LottoDto dto = lg.createDto();
        assertThat(dto.getLottos().size()).isEqualTo(2);
    }
}
