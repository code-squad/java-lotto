
import domain.Lotto;
import domain.LottoFactory;
import domain.LottoNum;
import domain.WinningRules;
import org.junit.Test;
import view.InputView;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoTest {

    @Test
    public void rankingTest() {
        WinningRules winningRules = new WinningRules();
        System.out.println(winningRules.ranking(5));
        winningRules.increase(5);
        System.out.println(winningRules.ranking(5));
        int num = 0;
        System.out.println(winningRules.ranking(num));
        winningRules.increase(num);
        System.out.println(winningRules.ranking(num));
    }

    @Test
    public void inputTest() {
        // 당첨번호 인풋 태스트
        String winnerLotto = "1,2,3,4,5,6";
        Lotto lotto = Lotto.winnerLottoCreator(InputView.separatorComa(winnerLotto));
        for (int i = 0; i < 6; i++) {
            assertThat(lotto.getNum(i)).isEqualTo(LottoNum.intCreate(i+1));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputExceptionTest() {
        String winnerLotto = "1,2,3,4,55,6";
        Lotto lotto = Lotto.winnerLottoCreator(InputView.separatorComa(winnerLotto));
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputExceptionTest2() {
        String winnerLotto = "1,2,3,4,6,6";
        Lotto lotto = Lotto.winnerLottoCreator(InputView.separatorComa(winnerLotto));
    }


    @Test(expected = IllegalArgumentException.class)
    public void LottoNumFalseTest() {
        LottoNum lottoNum3 = LottoNum.stringCreate("50");
        LottoNum lottoNum2 = LottoNum.intCreate(0);
        LottoNum lottoNum = LottoNum.intCreate(50);
    }

    @Test
    public void LottoNumTrueTest() {
        LottoNum lottoNum = LottoNum.intCreate(45);
        LottoNum lottoNum2 = LottoNum.intCreate(1);
        LottoNum lottoNum3 = LottoNum.stringCreate("23");

    }

    @Test
    public void makeLotto() {
        int lottoNum = 3;
        List<Lotto> lottos = new LottoFactory(lottoNum).getLottos();
        System.out.println(lottos.get(0));
        System.out.println(lottos.get(1));
        System.out.println(lottos.get(2));
        assertThat(lottos.size()).isEqualTo(3);

        lottos = new LottoFactory(20).getLottos();
        assertThat(lottos.size()).isEqualTo(20);
    }
}
