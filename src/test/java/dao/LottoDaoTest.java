package dao;

import dto.LottoDto;
import dto.LottosDto;
import org.junit.Before;
import org.junit.Test;
import vo.No;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LottoDaoTest {

    LottoDao lottoDao;

    @Before
    public void setUp() throws Exception {
        lottoDao = new LottoDao();
    }

    @Test
    public void createConnection() {
        Connection con = lottoDao.getConnection();
        assertNotNull(con);
    }

    @Test
    public void insert() throws SQLException {
        LottoDto lottoDto = LottoDto.init(Arrays.asList(
                new No(1),
                new No(2),
                new No(3),
                new No(4),
                new No(5),
                new No(6)));
        lottoDao.insert(lottoDto);
    }

    @Test
    public void insertAll() {
        List<LottoDto> lottosDto = new ArrayList<>();
        for (int i=0; i<3; i++) {
            lottosDto.add(LottoDto.init(Arrays.asList(
                    new No(1),
                    new No(2),
                    new No(3),
                    new No(4),
                    new No(5),
                    new No(6))));
        }

        lottoDao.insertAll(LottosDto.init(lottosDto));
    }

    @Test
    public void count() throws SQLException {
        assertEquals(lottoDao.count(), 4);
    }

    @Test
    public void clear() throws SQLException {
        lottoDao.clear();
        assertEquals(lottoDao.count(), 0);
    }

    @Test
    public void selectAll() throws SQLException {
        for (LottoDto lottoDto : lottoDao.selectAll().getLottoDtos()) {
            System.out.println(lottoDto);
        }
    }
}