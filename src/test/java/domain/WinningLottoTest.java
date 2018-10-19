package domain;

import org.junit.Before;
import org.junit.Test;
import vo.No;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WinningLottoTest {

    No bonusNum;
    Lotto winLotto;
    WinningLotto winningLotto;

    @Before
    public void setUp() {
        bonusNum = new No(7);

        List<No> lotto = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            lotto.add(new No(i));
        }
        winLotto = Lotto.initArtifitial(lotto);

        winningLotto = new WinningLotto(winLotto, bonusNum);
    }

    @Test
    public void compareWinLotto() {
        List<No> nums = new ArrayList<>();

        for (int i=2; i<8; i++) {
            nums.add(new No(i));
        }
        Lotto test = Lotto.initArtifitial(nums);

        System.out.println(winningLotto.compareWinLottoNum(test));
    }

}