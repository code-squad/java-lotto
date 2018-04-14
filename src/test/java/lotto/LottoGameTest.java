package lotto;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {

    @Test(expected = IllegalArgumentException.class)
    public void 공백문자입력() {
        LottoGames lottoGames = new LottoGames();
        lottoGames.buy("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자아닌값_입력() {
        LottoGames lottoGames = new LottoGames();
        lottoGames.buy("aaa");

    }

    @Test
    public void 천원단위구매() {
        LottoGames lottoGames = new LottoGames();
        lottoGames.buy("5000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 천원미만단위구매() {
        LottoGames lottoGames = new LottoGames();
        lottoGames.buy("500");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 천원미만단위포함구매() {
        LottoGames lottoGames = new LottoGames();
        lottoGames.buy("2500");
    }


    @Test
    public void 구매수량확인() {
        LottoGames lottoGames = new LottoGames();
        lottoGames.buy("4000");
        assertThat(lottoGames.getHavingLottos().size()).isEqualTo(4);
    }

    @Test
    public void 원하는수량만큼추가여부확인() {
        LottoGames lottoGames = new LottoGames();
        lottoGames.buyLottoNCounts(11);
        assertThat(lottoGames.getHavingLottos().size()).isEqualTo(11);
    }

    @Test
    public void 테스트용_내역추가() {
        LottoGames lottoGames = new LottoGames();
        lottoGames.addSingleLotto("1, 2, 3, 4, 5, 6");
        assertThat(lottoGames.getHavingLottos().size()).isEqualTo(1);
    }


    @Test
    public void 당첨번호입력시_리스트생성_확인() {
        LottoGames lottoGames = new LottoGames();
        String winString = "1, 2, 3, 4, 5, 6";
        lottoGames.setWinnerLotto(winString, "7");
        assertThat(lottoGames.getWinLotto().getWinLotto().getLotto().size()).isEqualTo(6);
    }


    @Test
    public void 두장_매칭결과가2개인지확인() {
        LottoGames lottoGames = new LottoGames();
        lottoGames.addSingleLotto("1, 2, 3, 4, 5, 26");
        lottoGames.addSingleLotto("1, 2, 3, 4, 5, 6");
        lottoGames.setWinnerLotto("1, 2, 3, 4, 5, 6", "7");

        int winCount = 0;
        Map<Rank, Integer> rankMap = lottoGames.getRankMap();
        for(Rank rank : rankMap.keySet()){
            winCount += rankMap.get(rank);
        }
        assertThat(winCount).isEqualTo(2);
    }


    @Test
    public void 두개모두전체꽝인경우_Map0이2인지확인() {
        LottoGames lottoGames = new LottoGames();
        lottoGames.addSingleLotto("11, 12, 13, 14, 15, 16");
        lottoGames.addSingleLotto("21, 22, 23, 24, 25, 26");
        lottoGames.setWinnerLotto("1, 2, 3, 4, 5, 6", "7");

        Map<Rank, Integer> rankMap = lottoGames.getRankMap();
        assertThat(rankMap.get(Rank.MISS)).isEqualTo(2);

    }

}
