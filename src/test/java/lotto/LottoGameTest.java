package lotto;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {

    @Test
    public void 천원단위구매() {
        LottoGames lottoGames = new LottoGames(5000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 천원미만단위구매() {
        LottoGames lottoGames = new LottoGames(500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 천원미만단위포함구매() {
        LottoGames lottoGames = new LottoGames(2500);
    }


    @Test
    public void 구매수량확인() {
        LottoGames lottoGames = new LottoGames(4000);
        assertThat(lottoGames.getHavingCount()).isEqualTo(4);
    }

    @Test
    public void 원하는수량만큼추가여부확인() {
        LottoGames lottoGames = new LottoGames(0);
        lottoGames.buyLottoNCounts(11);
        assertThat(lottoGames.getHavingCount()).isEqualTo(11);
    }

    @Test
    public void 테스트용_내역추가() {
        LottoGames lottoGames = new LottoGames(0);
        lottoGames.addSingleLotto("1, 2, 3, 4, 5, 6");
        assertThat(lottoGames.getHavingCount()).isEqualTo(1);
    }



    @Test
    public void 두장_매칭결과가2개인지확인() {
        LottoGames lottoGames = new LottoGames(0);
        lottoGames.addSingleLotto("1, 2, 3, 4, 5, 26");
        lottoGames.addSingleLotto("1, 2, 3, 4, 5, 6");
        List<String> winNumbers = new ArrayList<>();
        winNumbers.add("1, 2, 3, 4, 5, 6");
        winNumbers.add("7");
        lottoGames.setWinnerLotto(winNumbers);

        int winCount = 0;
        Map<Rank, Integer> rankMap = lottoGames.getRankMap();
        for(Rank rank : rankMap.keySet()){
            winCount += rankMap.get(rank);
        }
        assertThat(winCount).isEqualTo(2);
    }


    @Test
    public void 두개모두전체꽝인경우_Map0이2인지확인() {
        LottoGames lottoGames = new LottoGames(0);
        lottoGames.addSingleLotto("11, 12, 13, 14, 15, 16");
        lottoGames.addSingleLotto("21, 22, 23, 24, 25, 26");
        List<String> winNumbers = new ArrayList<>();
        winNumbers.add("1, 2, 3, 4, 5, 6");
        winNumbers.add("7");
        lottoGames.setWinnerLotto(winNumbers);

        Map<Rank, Integer> rankMap = lottoGames.getRankMap();
        assertThat(rankMap.get(Rank.MISS)).isEqualTo(2);

    }

}
