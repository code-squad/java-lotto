package step1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Before;
import org.junit.Test;
import step1.Lotto.Parser;
import step1.LottoResult.MatchKey;

public class LottoGameTest {
  Parser parserInLotto;
  LottoGame lottoGame;

  @Before
  public void setUp() throws Exception {
    parserInLotto = new Lotto().new Parser();
    lottoGame = new LottoGame();
  }

  @Test(expected = IllegalArgumentException.class)
  public void 입력값이_숫자가_아닐때_IllegalArgumentException_던짐() {
    parserInLotto.validateDigit("나는문자열");
  }

  @Test
  public void 입력받은_구입_금액에_맞는_로또_장수를_계산() {
    assertThat(lottoGame.getLottoGameNum("3000")).isEqualTo(3);
  }

  @Test
  public void 로또_장수만큼_로또_객체_생성() {
    Lottos lottos = new Lottos(4);
    assertThat(lottos.getLottos().size()).isEqualTo(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void 입력받은_번호묶음이_숫자가_아니면_IllegalArgumentException_던짐() {
    parserInLotto.splitor("문자,3,4,5,6,7");
  }

  @Test(expected = IllegalArgumentException.class)
  public void 입력받은_번호묶음이_로또숫자범위가_아니면_IllegalArgumentException_던짐() {
    parserInLotto.splitor("234,3,4,5,6,7");
  }

  @Test(expected = IllegalArgumentException.class)
  public void 입력받은_번호묶음에_중복되는_숫자가_있으면_IllegalArgumentException_던짐() {
    parserInLotto.splitor("3,3,4,5,6,7");
  }

  @Test
  public void 두_번호묶음의_일치하는_번호_갯수가_맞는지_확인() {
    assertThat(lottoGame.countSameNum(new Lotto(
            (List<Integer>) IntStream.rangeClosed(1, 6).boxed().collect(Collectors.toCollection(ArrayList::new))),
        new Lotto(
            (List<Integer>) IntStream.rangeClosed(2, 7).boxed().collect(Collectors.toCollection(ArrayList::new)))))
        .isEqualTo(5);
  }

  @Test
  public void 일치하는_번호수를_제대로_세는지_확인() {
    Lotto match3A = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,30,31,32)));
    Lotto match3B = new Lotto(new ArrayList<>(Arrays.asList(2,3,4,30,31,32)));
    Lotto match4 = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,30,31)));
    Lotto match5A = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,30)));
    Lotto match5B = new Lotto(new ArrayList<>(Arrays.asList(2,3,4,5,6,30)));
    Lotto match5C = new Lotto(new ArrayList<>(Arrays.asList(1,3,4,5,6,30)));
    Lotto match6 = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));

    Lotto jackpot = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));

    Lottos lottos = new Lottos(new ArrayList<Lotto>(Arrays.asList(match3A,match3B,match4,match5A,match5B,match5C,match6)));

    assertThat(lottoGame.match(jackpot, lottos))
        .isEqualTo(new LottoResult(new HashMap<String, Integer>() {{
          put(MatchKey.MATCH_3NUM_KEY, 2);
          put(MatchKey.MATCH_4NUM_KEY, 1);
          put(MatchKey.MATCH_5NUM_KEY, 3);
          put(MatchKey.MATCH_6NUM_KEY, 1);
        }}));
  }

  @Test
  public void 총수익률이_맞는지_확인() {
    assertThat(new LottoResult(new HashMap<String, Integer>() {
      {
        put(MatchKey.MATCH_3NUM_KEY, 1);
        put(MatchKey.MATCH_4NUM_KEY, 1);
        put(MatchKey.MATCH_5NUM_KEY, 0);
        put(MatchKey.MATCH_6NUM_KEY, 0);
      }}).getRateOfReturn(10)).isEqualTo(550);
  }
}

