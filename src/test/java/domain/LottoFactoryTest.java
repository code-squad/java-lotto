package domain;

import domaim.Lotto;
import domaim.LottoFactory;
import domaim.LottoNum;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {

    private List<LottoNum> lottos;
    @Before
    public void setUp() {
        lottos = new ArrayList<LottoNum>();
        for(int i = 1; i <= 6; i++) {
            lottos.add(new LottoNum(i));
        }
    }
}
