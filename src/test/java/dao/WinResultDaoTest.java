package dao;

import domain.WinningLotto;
import dto.LottoDto;
import dto.LottosDto;
import dto.WinResultDto;
import org.junit.Before;
import org.junit.Test;
import vo.No;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WinResultDaoTest {

    WinResultDao winResultDao;

    No bonusNum;
    LottoDto winLottoDto;
    WinningLotto winningLotto;

    @Before
    public void setUp() throws Exception {
        winResultDao = new WinResultDao();

        bonusNum = new No(7);

        List<No> lotto = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            lotto.add(new No(i));
        }
        winLottoDto = LottoDto.init(lotto);

        winningLotto = new WinningLotto(winLottoDto, bonusNum);
    }

    @Test
    public void insertAll() throws Exception {
        winResultDao.insertAll(winningLotto.checkWins(sampleLottosDto()));
    }

    @Test
    public void clear() throws SQLException {
        winResultDao.clear();
    }

    @Test
    public void selectAll() throws SQLException {
        System.out.println(winResultDao.selectAll());
    }

    public LottosDto sampleLottosDto() {
        List<LottoDto> lottosDto = new ArrayList<>();
        List<No> lotto = new ArrayList<>();

        // winningLotto의 번호와 같게 번호 생성
        for (int i = 1; i <= 6; i++) {
            lotto.add(new No(i));
        }

        // 수동 로또 세개를 winningLotto와 같은번호로 생성
        lottosDto.add(LottoDto.init(lotto));
        lottosDto.add(LottoDto.init(lotto));
        lottosDto.add(LottoDto.init(lotto));

        return LottosDto.init(lottosDto);
    }

}