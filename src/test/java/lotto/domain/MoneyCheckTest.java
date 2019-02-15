package lotto.domain;

import org.junit.Test;
import org.slf4j.Logger;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MoneyCheckTest {

    private MoneyCheck moneyCheck = new MoneyCheck();
    private static final Logger log = getLogger(MoneyCheckTest.class);

    private List<Lotto> getLottos() {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 11);
        List<Integer> b = Arrays.asList(1, 2, 3, 4, 5, 11);
        List<Integer> c = Arrays.asList(1, 2, 3, 4, 17, 19);
        List<Integer> d = Arrays.asList(1, 2, 3, 4, 5, 15);

        List<Lotto> lottos = Arrays.asList(new Lotto(a), new Lotto(b), new Lotto(c), new Lotto(d));
        return lottos;
    }

    public List<Integer> xx() {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 15);
        return a;
    }

    private List<Lotto> getUser() {
        List<Integer> a = Arrays.asList(1, 2, 3, 17, 18, 19);
        List<Integer> b = Arrays.asList(1, 2, 3, 4, 5, 11);
        List<Integer> c = Arrays.asList(1, 2, 3, 4, 5, 15);
        List<Lotto> lottos = Arrays.asList(new Lotto(a), new Lotto(b), new Lotto(c));
        return lottos;
    }

    @Test
    public void grade() {
        int bonus = 11;
        Grade grade = new Grade(getLottos(), getUser(), xx(), bonus);

        log.debug("{}", MoneyCheck.grade(grade));
    }

    @Test
    public void manualLottoObject() {
        List<String> a = Arrays.asList("1,2,8,7,5,6", "2,3,4,5,1,7", "3,4,5,1,7,2");
        System.out.println(LottoPlay.manualLottoObject(a));
    }
}