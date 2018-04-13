import lotto.GameResult;
import lotto.Lotto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.LottoGame.*;
import static org.assertj.core.api.Java6Assertions.assertThat;


public class LottoGameTest {

    @Test
    public void 수익률계산() {
        assertThat(getEarnRate(5000, 14000)).isEqualTo(35);
    }

    @Test
    public void 당첨된번호인지판별() {
        assertThat(assertMatch(new int[]{1,2,3,4,5,6}, 5)).isEqualTo(true);
    }

    @Test
    public void 스트링어레이를인트어레이로컨버트() {
        assertThat(convertStringArrayToIntArray(new String[]{"1", "2", "3", "4", "5", "6"})).isEqualTo(new int[]{1,2,3,4,5,6});
    }

    @Test
    public void 당첨번호와일치하는번호만필터해리스트로리턴() {
        List<Integer> lottoList = new ArrayList<>();
        lottoList.add(1);
        lottoList.add(2);
        lottoList.add(3);
        lottoList.add(4);
        lottoList.add(5);
        lottoList.add(6);

        Lotto lotto = new Lotto(lottoList);
        assertThat(matchNumber(lotto, new String[]{"1", "2", "3", "4", "5", "6"})).isEqualTo(lottoList);
    }

    @Test
    public void 결과저장() {
        List<Lotto> lottoList = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        temp.add(6);

        Lotto lotto = new Lotto(temp);

        lottoList.add(lotto);

        GameResult result = new GameResult();
        result.addMatch_six(matchNumber(lotto, new String[]{"1", "2", "3", "4", "5", "6"}));

        assertThat(saveResult(lottoList, new String[]{"1", "2", "3", "4", "5", "6"}, new GameResult()).getMatch_six().get(0)).isEqualTo(temp);
    }

}
