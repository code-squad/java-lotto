package generator;

import domain.Lotto;
import org.junit.Test;
import vo.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLottoGeneratorTest {

    @Test
    public void 수동로또생성() {
        //given
        List<String> manualLottos = new ArrayList<>(Arrays.asList(
                "1, 2, 3, 4, 5, 6",
                "2, 3, 4, 5, 6, 7",
                "3, 4, 5, 6, 7, 8"
        ));
        ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator(manualLottos);

        Lotto lotto1 = new Lotto(new ArrayList<>(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
        Lotto lotto2 = new Lotto(new ArrayList<>(Arrays.asList(
                new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6), new LottoNumber(7))));
        Lotto lotto3 = new Lotto(new ArrayList<>(Arrays.asList(
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                new LottoNumber(6), new LottoNumber(7), new LottoNumber(8))));
        List<Lotto> exPectedLottos = new ArrayList<>(Arrays.asList(lotto1, lotto2, lotto3));

        //when
        List<Lotto> lottos = manualLottoGenerator.generateLotto();

        //then
        assertThat(lottos.size()).isEqualTo(3);
        assertThat(lottos).isEqualTo(exPectedLottos);
    }
}