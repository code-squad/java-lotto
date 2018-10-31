package domain;

import domain.vo.LottoNum;
import org.junit.Test;
import view.InputView;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoTest {


    @Test
    public void winnerLotto와lotto추상클래스태스트() {
        String input = "1,2,3,4,5,6";
        WinnerLotto winnerLotto = WinnerLotto.of(InputView.separatorComa(input),7);
        Lotto lotto = Lotto.ofManual(InputView.separatorComa(input));
        int num = winnerLotto.compareLotto(lotto);
        assertThat(num).isEqualTo(6);
    }
   /* @Test
    public void winnerLotto생성() {
        String input = "1,3,2,4,6,5";
        WinnerLotto winnerLotto = WinnerLotto.of(InputView.separatorComa(input),7);
        winnerLotto.setBonus(7);
        System.out.println(winnerLotto);
        for (int i = 0; i < 6; i++) {
            assertThat(winnerLotto.getNum(i)).isEqualTo(LottoNum.ofInt(i+1));
        }
        assertThat(winnerLotto.getBonus()).isEqualTo(7);
    }
*/
    @Test
    public void rankingTest() {
        LottoryManager lottoryManager = LottoryManager.of(1000);
        System.out.println(lottoryManager.findRank(Rank.FIVE));
        lottoryManager.increase(5,true);
        System.out.println(lottoryManager.findRank(Rank.THREE));
        int num = 0;
        System.out.println(lottoryManager.findRank(null));
        lottoryManager.increase(num,false);
        System.out.println(lottoryManager.findRank(null));
    }

    @Test
    public void inputTest() {
        // 당첨번호 인풋 태스트
        String winnerLotto = "1,2,3,4,5,6";
        Lotto lotto = Lotto.ofManual(InputView.separatorComa(winnerLotto));
        for (int i = 0; i < 6; i++) {
            assertThat(lotto.getNum(i)).isEqualTo(LottoNum.ofInt(i+1));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputExceptionTest() {
        String winnerLotto = "1,2,3,4,55,6";
        Lotto lotto = Lotto.ofManual(InputView.separatorComa(winnerLotto));
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputExceptionTest2() {
        String winnerLotto = "1,2,3,4,6,6";
        Lotto lotto = Lotto.ofManual(InputView.separatorComa(winnerLotto));
    }


    @Test(expected = IllegalArgumentException.class)
    public void lottoNumFalseTest() {
        LottoNum lottoNum3 = LottoNum.ofString("50");
        LottoNum lottoNum2 = LottoNum.ofInt(0);
        LottoNum lottoNum = LottoNum.ofInt(50);
    }

    @Test
    public void lottoNumTrueTest() {
        LottoNum lottoNum = LottoNum.ofInt(45);
        LottoNum lottoNum2 = LottoNum.ofInt(1);
        LottoNum lottoNum3 = LottoNum.ofString("23");

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
