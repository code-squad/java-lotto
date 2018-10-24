package domain;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @Test
    public void countGameNum() {
        /* 인스턴스 변수를 사용하지 않는 메소드이기 때문에 스태틱 메소드를 사용 */
        assertThat(LottoGame.countGameNum(19000)).isEqualTo(19);
    }

    @Test
    public void matchLottoResultTest() {
        List<LottoNum> lotto = new ArrayList<>();
        lotto.add(new LottoNum(1)); lotto.add(new LottoNum(2)); lotto.add(new LottoNum(3));
        lotto.add(new LottoNum(4)); lotto.add(new LottoNum(5)); lotto.add(new LottoNum(6));
        Lotto myLotto = new Lotto(lotto);

        List<LottoNum> winngig = new ArrayList<>();
        winngig.add(new LottoNum(2)); winngig.add(new LottoNum(3)); winngig.add(new LottoNum(4));
        winngig.add(new LottoNum(5)); winngig.add(new LottoNum(6)); winngig.add(new LottoNum(7));
        WinningLotto winningLotto = new WinningLotto(winngig, new LottoNum(1));
        assertThat(LottoGame.matchLottoResult(myLotto, winningLotto)).isEqualTo(LottoResult.SECOND);
    }
}
