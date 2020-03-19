package generator;

import domain.Lotto;
import org.junit.Test;
import vo.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegratedLottoGeneratorTest {

    @Test
    public void 통합로또공장생성() {
        //given
        Lotto lotto1 = new Lotto(new ArrayList<>(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
        Lotto lotto2 = new Lotto(new ArrayList<>(Arrays.asList(
                new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6), new LottoNumber(7))));
        List<Lotto> autoLottos = new ArrayList<>(Arrays.asList(lotto1, lotto2));

        Lotto lotto3 = new Lotto(new ArrayList<>(Arrays.asList(
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                new LottoNumber(6), new LottoNumber(7), new LottoNumber(8))));
        List<Lotto> manualLottos = new ArrayList<>(Arrays.asList(lotto3));

        IntegratedLottoGenerator integratedLottoGenerator = new IntegratedLottoGenerator(autoLottos, manualLottos);

        //when
        List<Lotto> lottos = integratedLottoGenerator.getLottos();

        //then
        assertThat(lottos.size()).isEqualTo(3);
    }
}