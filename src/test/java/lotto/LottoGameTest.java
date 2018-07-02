package lotto;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {

    @Test
    public void 천원단위구매() {
        String [] manualLotto = {};
        LottoGames lottoGames = new LottoGames(5000, manualLotto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 천원미만단위구매() {
        String [] manualLotto = {};
        LottoGames lottoGames = new LottoGames(500, manualLotto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 천원미만단위포함구매() {
        String [] manualLotto = {};
        LottoGames lottoGames = new LottoGames(2500, manualLotto);
    }


    @Test
    public void 구매수량확인() {
        String [] manualLotto = {};
        LottoGames lottoGames = new LottoGames(4000, manualLotto);
        assertThat(lottoGames.getHavingCount()).isEqualTo(4);
    }

    @Test
    public void 원하는수량만큼추가여부확인() {
        String [] manualLotto = {};
        LottoGames lottoGames = new LottoGames(11000, manualLotto);
        assertThat(lottoGames.getHavingCount()).isEqualTo(11);
    }

    @Test
    public void 테스트용_내역추가() {
        String [] manualLotto = {};
        LottoGames lottoGames = new LottoGames(0, manualLotto);
        lottoGames.addSingleLotto("1, 2, 3, 4, 5, 6");
        assertThat(lottoGames.getHavingCount()).isEqualTo(1);
    }



    @Test
    public void 두장_매칭결과가2개인지확인() {
        String [] manualLotto = {};
        LottoGames lottoGames = new LottoGames(0, manualLotto);
        lottoGames.addSingleLotto("1, 2, 3, 4, 5, 26");
        lottoGames.addSingleLotto("1, 2, 3, 4, 5, 6");
        List<String> winNumbers = new ArrayList<>();
        winNumbers.add("1, 2, 3, 4, 5, 6");
        winNumbers.add("7");
        lottoGames.setWinLotto(winNumbers);

        int winCount = 0;
        Map<Rank, Integer> rankMap = lottoGames.getRankMap();
        for(Rank rank : rankMap.keySet()){
            winCount += rankMap.get(rank);
        }
        assertThat(winCount).isEqualTo(2);
    }


    @Test
    public void 두개모두전체꽝인경우_Map0이2인지확인() {
        String [] manualLotto = {};
        LottoGames lottoGames = new LottoGames(0, manualLotto);
        lottoGames.addSingleLotto("11, 12, 13, 14, 15, 16");
        lottoGames.addSingleLotto("21, 22, 23, 24, 25, 26");
        List<String> winNumbers = new ArrayList<>();
        winNumbers.add("1, 2, 3, 4, 5, 6");
        winNumbers.add("7");
        lottoGames.setWinLotto(winNumbers);

        Map<Rank, Integer> rankMap = lottoGames.getRankMap();
        assertThat(rankMap.get(Rank.MISS)).isEqualTo(2);

    }

}
