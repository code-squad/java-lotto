package lotttoOlder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Before;
import org.junit.Test;

//TODO 객체간 결합 관계 파악
//TODO 로또게임 테스트와 클래스 로직 테스트 나누기
public class LottoGameTest {
  LottoGame lottoGame;

  @Before
  public void setUp() throws Exception {
    lottoGame = new LottoGame();
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

  @Test
  public void 두_로또의_일치하는_번호_갯수를_제대로_세는지_확인() {
    Lotto lotto = new Lotto(
        (List<Integer>) IntStream.rangeClosed(2, 7).boxed().collect(Collectors.toCollection(ArrayList::new)));
    Lotto jackpot = new Lotto(
        (List<Integer>) IntStream.rangeClosed(1, 6).boxed().collect(Collectors.toCollection(ArrayList::new)));

    assertThat(lotto.countSameNumber(jackpot)).isEqualTo(5);
  }

  @Test
  public void 전체_로또게임의_일치하는_번호_갯수별로_몇장인지를_제대로_세는지_확인() {
    Lotto jackpot = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));

    Lotto match3A = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,30,31,32)));
    Lotto match3B = new Lotto(new ArrayList<>(Arrays.asList(2,3,4,30,31,32)));
    Lotto match4 = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,30,31)));
    Lotto match5A = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,30)));
    Lotto match5B = new Lotto(new ArrayList<>(Arrays.asList(2,3,4,5,6,30)));
    Lotto match5C = new Lotto(new ArrayList<>(Arrays.asList(1,3,4,5,6,30)));
    Lotto match6 = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
    Lottos lottos = new Lottos(new ArrayList<Lotto>(Arrays.asList(match3A,match3B,match4,match5A,match5B,match5C,match6)));

//    TODO test바꾸기 - 개발자가 몇개 매칭이 몇등인지 외우고 있어야함
    assertThat(lottoGame.match(jackpot, lottos))
        .isEqualTo(new LottoResult(new HashMap<String, Integer>() {{
          put(LottoInfo.FOURTH.getMapKey(), 2);
          put(LottoInfo.THIRD.getMapKey(), 1);
          put(LottoInfo.SECOND.getMapKey(), 3);
          put(LottoInfo.FIRST.getMapKey(), 1);
        }}));
  }

  @Test
  public void 총_수익률이_맞는지_확인() {
    assertThat(new LottoResult(new HashMap<String, Integer>() {
      {
        put(LottoInfo.FOURTH.getMapKey(), 1);
        put(LottoInfo.THIRD.getMapKey(), 1);
        put(LottoInfo.SECOND.getMapKey(), 0);
        put(LottoInfo.FIRST.getMapKey(), 0);
      }}).calProfit(10)).isEqualTo(550);
  }
}

