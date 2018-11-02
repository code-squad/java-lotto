package lottogame.dao;

import lottogame.domain.Lotto;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoDaoTest {
    private LottoDao dao;
    @Before
    public void before(){
        dao = new LottoDao();
    }

    @Test
    public void selectTest() {
        String ret = dao.select();
        System.out.println(ret);
    }

    @Test
    public void insertTest() {
        boolean i = dao.insert("2,3,4,5,6,7");
        System.out.println(i);
    }

    @Test
    public void insertLottoTest() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.ofText("1,2,3,4,5,6"));
        lottos.add(Lotto.ofText("2,3,4,5,6,7"));

        dao.insertLotto(lottos);
    }

    @Test
    public void selectLottoTest(){
        List<Lotto> lottos = dao.selectLotto();
    }
}