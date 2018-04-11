package javaLotto;

import javaLotto.domain.*;
import javaLotto.utils.LottoNumberGenerator;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaLottoTest {

    @Test
    public void start() throws Exception{

    }

    @Test
    public void 구매1개()throws Exception{
        Lotto lotto =  JavaLotto.buyLotto(1000);
        assertThat(lotto.getSize()).isEqualTo(1);
    }
    @Test
    public void 구매2개()throws Exception{
        Lotto lotto =  JavaLotto.buyLotto(2900);
        assertThat(lotto.getSize()).isEqualTo(2);
    }
    @Test
    public void 로또번호생성()throws Exception{
       LottoTicket numbers = LottoNumberGenerator.makeLottoNumber();
        assertThat(numbers.getLottoTicket().size()).isEqualTo(6);
    }
    @Test
    public void 지난주당첨번호생성()throws Exception{
        WinningNumber winngNumber = new WinningNumber("1,2,3,4,5,6");
        List expect = Arrays.asList(1,2,3,4,5,6);
        assertThat(winngNumber.getWinningNumber()).isEqualTo(expect);
    }
    @Test
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
    }


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
