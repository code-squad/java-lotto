package domain;

import dto.LottoDto;
import dto.LottoDtos;
import org.junit.Before;
import org.junit.Test;
import vo.No;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WinningLottoTest {

    No bonusNum;
    Lotto winLotto;
    WinningLotto winningLotto;

    @Before
    public void setUp() throws Exception {
        bonusNum = new No(7);

        List<No> lotto = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            lotto.add(new No(i));
        }
        winLotto = Lotto.initArtifitial(lotto);

        winningLotto = new WinningLotto(winLotto, bonusNum);
    }

    @Test
    public void compareWinLotto() throws Exception {
        List<No> nums = new ArrayList<>();

        for (int i = 2; i < 8; i++) {
            nums.add(new No(i));
        }
        Lotto test = Lotto.initArtifitial(nums);

        System.out.println(winningLotto.compareWinLottoNum(test));
    }

    @Test
    public void checkWins() throws Exception {
        List<LottoDto> lottos = new ArrayList<>();
        List<No> lotto = new ArrayList<>();

        // winningLotto의 번호와 같게 번호 생성
        for (int i = 1; i <= 6; i++) {
            lotto.add(new No(i));
        }

        // 수동 로또 세개를 winningLotto와 같은번호로 생성
        lottos.add(LottoDto.init(lotto));
        lottos.add(LottoDto.init(lotto));
        lottos.add(LottoDto.init(lotto));

        LottoDtos lottoDtos = LottoDtos.init(lottos);

        System.out.println(winningLotto.checkWins(LottoGenerator.initAutoAndArtifitial(lottoDtos, 5).toLottoDtos()));
    }

}