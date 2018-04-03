package lotto.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import lotto.db.Common;
import lotto.db.LottoDAO;
import lotto.db.LottoDTO;

public class LottoDAOTest {

	private LottoDAO lottoDAO;
	private LottoDTO lottoDTO;

	@Before
	public void setUp() {
		lottoDAO = new LottoDAO();
		lottoDTO = new LottoDTO();
	}

	@Test
	public void connection() {
		Connection con = Common.getConnection();
		assertNotNull(con);
	}

	@Test
	public void insert() throws Exception {
		List<Integer> temp = Arrays.asList(1, 2, 3, 4, 5, 6);
		lottoDTO.setNumbers(temp);
		lottoDAO.insert(lottoDTO);
	}

	@Test
	public void delete() throws Exception {
		lottoDAO.delete();
	}

}
