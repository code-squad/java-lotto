package lottoGame.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoStaticResultTest {

    @Test
    public void 로또당첨통계데이터일치3개확인() {

       List<Lotto> lottoes = new ArrayList<>();
       Lotto lotto = new Lotto(Arrays.asList(3,4,11,15,22,30));
       lottoes.add(lotto);

       LottoStaticResult lottoStaticResult = LottoStaticResult.makeLottoStaticResult(lottoes, new WinningLotto(new HashSet(Arrays.asList(3,4,11)),1));
       assertThat(lottoStaticResult.getLottoStatisticsCntResult(LottoRank.FIFTH)).isEqualTo(1);
    }

    @Test
    public void 로또당첨통계데이터일치5개확인() {

       List<Lotto> lottoes = new ArrayList<>();
       Lotto lotto = new Lotto(Arrays.asList(33,42,11,18,22,30));
       Lotto lotto2 = new Lotto(Arrays.asList(33,42,11,3,22,30));
       lottoes.add(lotto);
       lottoes.add(lotto2);


       LottoStaticResult lottoStaticResult = LottoStaticResult.makeLottoStaticResult(lottoes,new WinningLotto(new HashSet(Arrays.asList(33,42,11,30,22)),3));
       assertThat(lottoStaticResult.getLottoStatisticsCntResult(LottoRank.THIRD)).isEqualTo(1);
        assertThat(lottoStaticResult.getLottoStatisticsCntResult(LottoRank.SECOND)).isEqualTo(1);

    }

    @Test
    public void 로또수익율확인() {

       List<Lotto> lottoes = new ArrayList<Lotto>();
       lottoes.add(new Lotto(Arrays.asList(33,42,11,18,22,30)));

       LottoStaticResult lottoStaticResult = LottoStaticResult.makeLottoStaticResult(lottoes,new WinningLotto(new HashSet(Arrays.asList(33,42,11,18,20,30)),4));
       assertThat(lottoStaticResult.getProfitPercent(1500000)).isEqualTo(100);

       LottoStaticResult lottoStaticResult2 = LottoStaticResult.makeLottoStaticResult(lottoes,new WinningLotto(new HashSet(Arrays.asList(33,42,11,0,0,0)),5));
       assertThat(lottoStaticResult2.getProfitPercent(14000)).isEqualTo(35);
    }
}