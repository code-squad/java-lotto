package lottoGame.domain;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoStaticResultTest {

    @Test
    public void 로또당첨통계데이터일치3개확인() {

       ArrayList<Integer> lottoNums = new ArrayList<Integer>();
       lottoNums.add(3);
       lottoNums.add(4);
       lottoNums.add(11);
       lottoNums.add(15);
       lottoNums.add(22);
       lottoNums.add(30);
       Lotto[] lottoes = new Lotto[1];
       Lotto lotto = new Lotto(lottoNums);
       lottoes[0] = lotto;

       int[] luckyNums = new int[6];
       luckyNums[0] = 3;
       luckyNums[1] = 4;
       luckyNums[2] = 11;

       LottoStaticResult lottoStaticResult = LottoStaticResult.makeLottoStaticResult(lottoes,luckyNums);
       assertThat(lottoStaticResult.getThreeLuckyNum()).isEqualTo(1);
    }

    @Test
    public void 로또당첨통계데이터일치5개확인() {

       ArrayList<Integer> lottoNums = new ArrayList<Integer>();
       lottoNums.add(33);
       lottoNums.add(42);
       lottoNums.add(11);
       lottoNums.add(18);
       lottoNums.add(22);
       lottoNums.add(30);
       Lotto[] lottoes = new Lotto[1];
       Lotto lotto = new Lotto(lottoNums);
       lottoes[0] = lotto;

       int[] luckyNums = new int[6];
       luckyNums[0] = 33;
       luckyNums[1] = 42;
       luckyNums[2] = 11;
       luckyNums[3] = 30;
       luckyNums[4] = 22;

       LottoStaticResult lottoStaticResult = LottoStaticResult.makeLottoStaticResult(lottoes,luckyNums);
       assertThat(lottoStaticResult.getFiveLuckyNum()).isEqualTo(1);
    }

    @Test
    public void 로또수익율확인() {

       ArrayList<Integer> lottoNums = new ArrayList<Integer>();
       lottoNums.add(33);
       lottoNums.add(42);
       lottoNums.add(11);
       lottoNums.add(18);
       lottoNums.add(22);
       lottoNums.add(30);
       Lotto[] lottoes = new Lotto[1];
       Lotto lotto = new Lotto(lottoNums);
       lottoes[0] = lotto;

       int[] luckyNums = new int[6];
       luckyNums[0] = 33;
       luckyNums[1] = 42;
       luckyNums[2] = 11;
       luckyNums[3] = 30;
       luckyNums[4] = 22;

       LottoStaticResult lottoStaticResult = LottoStaticResult.makeLottoStaticResult(lottoes,luckyNums);
       assertThat(lottoStaticResult.getProfitPercent(1500000)).isEqualTo(100);

       luckyNums[3] = 0;
       luckyNums[4] = 0;

       LottoStaticResult lottoStaticResult2 = LottoStaticResult.makeLottoStaticResult(lottoes,luckyNums);
       assertThat(lottoStaticResult2.getProfitPercent(14000)).isEqualTo(35);
    }
}