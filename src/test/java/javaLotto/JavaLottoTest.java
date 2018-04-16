package javaLotto;

import javaLotto.domain.*;
import javaLotto.utils.LottoNumberGenerator;
import javaLotto.view.InputView;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static javaLotto.utils.LottoNumberGenerator.makeLottoNumber;
import static org.assertj.core.api.Assertions.assertThat;

public class JavaLottoTest {

    @Test
    public void start() throws Exception {

    }

    @Test
    public void 구매1개_자동구매() throws Exception {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        lottoTickets.add(LottoNumberGenerator.makeLottoNumber());
        Lotto lotto = JavaLotto.buyLotto(1000, lottoTickets);
        assertThat(lotto.getSize()).isEqualTo(1);
    }

    @Test
    public void 구매3개_자동구매() throws Exception {
        List<LottoTicket> lottoTickets;
        lottoTickets = Arrays.asList(LottoNumberGenerator.makeLottoNumber(), LottoNumberGenerator.makeLottoNumber(), LottoNumberGenerator.makeLottoNumber());
        Lotto lotto = JavaLotto.buyLotto(3000, lottoTickets);
        assertThat(lotto.getSize()).isEqualTo(3);
    }

    @Test
    public void 수동구매1() throws Exception {
        List<LottoTicket> lottoTickets;
        lottoTickets = Arrays.asList(LottoNumberGenerator.makeLottoNumberManual("1,2,3,4,5,6"));
        Lotto lotto = JavaLotto.buyLotto(1000, lottoTickets);
        assertThat(lotto.getSize()).isEqualTo(1);
    }

    @Test
    public void 수동구매2개() throws Exception {
        List<LottoTicket> lottoTickets;
        lottoTickets = Arrays.asList(LottoNumberGenerator.makeLottoNumberManual("1,2,3,4,5,6"), LottoNumberGenerator.makeLottoNumberManual("1,2,3,4,5,6"));
        Lotto lotto = JavaLotto.buyLotto(2900, lottoTickets);
        assertThat(lotto.getSize()).isEqualTo(2);
    }


    @Test
    public void 수동1개자동2개구매() throws Exception {
        List<LottoTicket> lottoTickets;
        lottoTickets = Arrays.asList( LottoNumberGenerator.makeLottoNumber(),LottoNumberGenerator.makeLottoNumberManual("1,2,3,4,5,6"), LottoNumberGenerator.makeLottoNumberManual("1,2,3,4,5,6"));
        Lotto lotto = JavaLotto.buyLotto(3900, lottoTickets);
        assertThat(lotto.getSize()).isEqualTo(3);
    }
    @Test
    public void 수동2개자동2개구매() throws Exception {
        List<LottoTicket> lottoTickets;
        lottoTickets = Arrays.asList( LottoNumberGenerator.makeLottoNumber(),LottoNumberGenerator.makeLottoNumber(),LottoNumberGenerator.makeLottoNumberManual("1,2,3,4,5,6"), LottoNumberGenerator.makeLottoNumberManual("1,2,3,4,5,6"));
        Lotto lotto = JavaLotto.buyLotto(4000, lottoTickets);
        assertThat(lotto.getSize()).isEqualTo(4);
    }

    @Test
    public void 로또번호생성() throws Exception {
        LottoTicket numbers = makeLottoNumber();
        assertThat(numbers.getLottoTicket().size()).isEqualTo(6);
    }

    @Test
    public void 지난주당첨번호생성() throws Exception {
        WinningNumber winngNumber = new WinningNumber("1,2,3,4,5,6", "7");
        Set expect = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)).stream().collect(Collectors.toSet());
        assertThat(winngNumber.getWinningNumber()).isEqualTo(expect);
    }


    @Test(expected = IllegalArgumentException.class)
    public void 로또티켓_중복불가() throws Exception {
        LottoNumberGenerator.makeLottoNumberManual("1,1,3,4,5,6");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_6개이상() throws Exception {
        LottoNumberGenerator.makeLottoNumberManual("1,2,3,4,5,6,7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_6개이하() throws Exception {
        LottoNumberGenerator.makeLottoNumberManual("1,1,3");

    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또티켓_범위1to45이하() throws Exception {
        LottoNumberGenerator.makeLottoNumberManual("1,1,3");

    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또티켓_범위1to45이상() throws Exception {
        LottoNumberGenerator.makeLottoNumberManual("1,1,3,4,5,55");

    }

    @Test
    public void 로또티켓_valueOf_5등() throws Exception {
        Rank rank = Rank.valueOf(3, false);
        assertThat(rank.name()).isEqualTo(Rank.FIFTH.name());
    }

    @Test
    public void 로또티켓_valueOf_4등() throws Exception {
        Rank rank = Rank.valueOf(4, false);
        assertThat(rank.name()).isEqualTo(Rank.FOURTH.name());
    }

    @Test
    public void 로또티켓_valueOf_3등() throws Exception {
        Rank rank = Rank.valueOf(5, false);
        assertThat(rank.name()).isEqualTo(Rank.THIRD.name());
    }

    @Test
    public void 로또티켓_valueOf_2등() throws Exception {
        Rank rank = Rank.valueOf(5, true);
        assertThat(rank.name()).isEqualTo(Rank.SECOND.name());
    }

    @Test
    public void 로또티켓_valueOf_1등() throws Exception {
        Rank rank = Rank.valueOf(6, false);
        assertThat(rank.name()).isEqualTo(Rank.FIRST.name());
    }


 /*   @Test
    public void 당첨번호확인3등 ()throws Exception{
        List result = Arrays.asList(3,3);
        int count = Grade.returnGrade(result,3);
        assertThat(count).isEqualTo(2);
    }
    @Test
    public void 당첨번호확인4등 ()throws Exception{
        List result = Arrays.asList(4,4);
        int count = Grade.returnGrade(result,4);
        assertThat(count).isEqualTo(2);
    }
    @Test
    public void 당첨번호확인5등 ()throws Exception{
        List<Integer> result = new ArrayList<>();
        result.add(5);
        int count = Grade.returnGrade(result,5);
        assertThat(count).isEqualTo(1);
    }
    @Test
    public void 당첨번호확인6등 ()throws Exception{
        List<Integer> result = new ArrayList<>();
        result.add(6);
        int count = Grade.returnGrade(result,6);
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void 퍼센트계산100 ()throws Exception{
        List<Integer> result = new ArrayList<>();
        result.add(3);
        double percent = Grade.returnPercent(result,5000);
        assertThat(percent).isEqualTo(100);
    }

    @Test
    public void 퍼센트계산200 ()throws Exception{
        List result = Arrays.asList(3,3);
        double percent = Grade.returnPercent(result,5000);
        assertThat(percent).isEqualTo(200);
    }*/


/*    @Test
    public void 구매() throws Exception{
        JavaLotto javaLotto = new JavaLotto();
        int buyLotto = javaLotto.buyLotto(10000);
        assertThat(buyLotto).isEqualTo(10);
    }
    @Test
    public void 구매100원단위() throws Exception{
        JavaLotto javaLotto = new JavaLotto();
        int buyLotto = javaLotto.buyLotto(10900);
        assertThat(buyLotto).isEqualTo(10);
    }

    @Test(expected = Exception.class)
    public void 천원이하구매() throws Exception{
        JavaLotto javaLotto = new JavaLotto();
        int buyLotto = javaLotto.buyLotto(999);
    }

    @Test(expected = Exception.class)
    public void 음수구매() throws Exception{
        JavaLotto javaLotto = new JavaLotto();
        int buyLotto = javaLotto.buyLotto(-0);
    }

    @Test(expected = Exception.class)
    public void 널값() throws Exception{
        JavaLotto javaLotto = new JavaLotto();

    }*/
/*
    @Test
    public void lotto구매파라미터변경() throws Exception{
        JavaLotto javaLotto = new JavaLotto();
        new Lotto(1000);
        List<Lotto> lotto = javaLotto.buyLotto2(new Lotto(10000));
        assertThat(lotto).isEqualTo(lotto);
    }*/


}
