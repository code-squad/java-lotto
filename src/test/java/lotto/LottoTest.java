package lotto;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 공백문자입력() {
        Lotto lotto = new Lotto();
        lotto.buy("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자아닌값_입력() {
        Lotto lotto = new Lotto();
        lotto.buy("aaa");

    }

    @Test
    public void 천원단위구매() {
        Lotto lotto = new Lotto();
        lotto.buy("5000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 천원미만단위구매() {
        Lotto lotto = new Lotto();
        lotto.buy("500");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 천원미만단위포함구매() {
        Lotto lotto = new Lotto();
        lotto.buy("2500");
    }

    @Test
    public void 한라운드_생성_테스트() {
        Lotto lotto = new Lotto();
        List<Integer> singleTicket = lotto.generateSigleTicket();
        assertThat(singleTicket.size()).isEqualTo(6);
    }

    @Test
    public void 구매수량확인() {
        Lotto lotto = new Lotto();
        lotto.buy("4000");
        assertThat(lotto.getHavingLottos().size()).isEqualTo(4);
    }

    @Test
    public void 원하는수량만큼추가여부확인() {
        Lotto lotto = new Lotto();
        lotto.buyLottoNCounts(11);
        assertThat(lotto.getHavingLottos().size()).isEqualTo(11);
    }

    @Test
    public void 테스트용_내역추가() {
        Lotto lotto = new Lotto();
        List<Integer> addTicket = new ArrayList<>();
        Integer [] winNumber = new Integer[]{1, 2, 3, 4, 5, 6};
        addTicket.addAll( Arrays.asList( winNumber ) );
        lotto.addSingleTicket(addTicket);
        assertThat(lotto.getHavingLottos().size()).isEqualTo(1);
    }

    @Test
    public void 당첨번호입력시_리스트생성_확인() {
        Lotto lotto = new Lotto();
        String winString = "1, 2, 3, 4, 5, 6";
        List<Integer> winNumbers = lotto.makeWinNumbersFromString(winString);
        assertThat(winNumbers.size()).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨번호갯수미만오류확인() {
        Lotto lotto = new Lotto();
        String winString = "1, 2, 3, 4, 5";
        List<Integer> winNumbers = lotto.makeWinNumbersFromString(winString);

    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨번호갯수초과확인() {
        Lotto lotto = new Lotto();
        String winString = "1, 2, 3, 4, 5, 6, 7";
        List<Integer> winNumbers = lotto.makeWinNumbersFromString(winString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨번호중복내역오류처리확인() {
        Lotto lotto = new Lotto();
        String winString = "1, 2, 3, 4, 5, 1";
        List<Integer> winNumbers = lotto.makeWinNumbersFromString(winString);
    }

    @Test
    public void 한장_전체매칭확인() {
        Lotto lotto = new Lotto();
        List<Integer> addTicket = new ArrayList<>();
        Integer [] winNumber = new Integer[]{1, 2, 3, 4, 5, 6};
        addTicket.addAll( Arrays.asList( winNumber ) );

        String winString = "1, 2, 3, 4, 5, 6";
        int matchCount = lotto.getMatchSingleTicketCount(addTicket, winString);
        assertThat(matchCount).isEqualTo(6);
    }

    @Test
    public void 한장_부분매칭확인() {
        Lotto lotto = new Lotto();
        List<Integer> addTicket = new ArrayList<>();
        Integer [] winNumber = new Integer[]{1, 2, 3, 4, 5, 26};
        addTicket.addAll( Arrays.asList( winNumber ) );

        String winString = "1, 2, 3, 4, 5, 6";
        int matchCount = lotto.getMatchSingleTicketCount(addTicket, winString);
        assertThat(matchCount).isEqualTo(5);
    }

    @Test
    public void 두장_매칭결과가2개인지확인() {
        Lotto lotto = new Lotto();
        List<Integer> addTicket = new ArrayList<>();
        Integer [] winNumber = new Integer[]{1, 2, 3, 4, 5, 26};
        addTicket.addAll( Arrays.asList( winNumber ) );
        lotto.addSingleTicket(addTicket);
        winNumber = new Integer[]{1, 2, 3, 4, 5, 6};
        addTicket = new ArrayList<>();
        addTicket.addAll( Arrays.asList( winNumber ) );
        lotto.addSingleTicket(addTicket);

        String winString = "1, 2, 3, 4, 5, 6";
        Map<Integer, Integer> winnerMap = lotto.getWinnerMap(winString);
        assertThat(winnerMap.size()).isEqualTo(2);
    }

    @Test
    public void 두개모두전체꽝인경우_Map이1개리턴하나확인() {
        Lotto lotto = new Lotto();
        List<Integer> addTicket = new ArrayList<>();
        Integer [] winNumber = new Integer[]{21, 22, 23, 24, 25, 26};
        addTicket.addAll( Arrays.asList( winNumber ) );
        lotto.addSingleTicket(addTicket);
        winNumber = new Integer[]{11, 12, 13, 14, 15, 16};
        addTicket = new ArrayList<>();
        addTicket.addAll( Arrays.asList( winNumber ) );
        lotto.addSingleTicket(addTicket);

        String winString = "1, 2, 3, 4, 5, 6";
        Map<Integer, Integer> winnerMap = lotto.getWinnerMap(winString);
        assertThat(winnerMap.size()).isEqualTo(1);
    }

    @Test
    public void 두개모두전체꽝인경우_Map0이2인지확인() {
        Lotto lotto = new Lotto();
        List<Integer> addTicket = new ArrayList<>();
        Integer [] winNumber = new Integer[]{21, 22, 23, 24, 25, 26};
        addTicket.addAll( Arrays.asList( winNumber ) );
        lotto.addSingleTicket(addTicket);
        winNumber = new Integer[]{11, 12, 13, 14, 15, 16};
        addTicket = new ArrayList<>();
        addTicket.addAll( Arrays.asList( winNumber ) );
        lotto.addSingleTicket(addTicket);

        String winString = "1, 2, 3, 4, 5, 6";
        Map<Integer, Integer> winnerMap = lotto.getWinnerMap(winString);
        assertThat(winnerMap.get(0)).isEqualTo(2);

    }
}
