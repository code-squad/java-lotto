package lotto.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import lotto.db.ResultDAO;
import lotto.db.ResultDTO;

public class ResultDAOTest {

	private ResultDAO resultDAO;
	private ResultDTO resultDTO;

	@Before
	public void setUp() {
		resultDAO = new ResultDAO();
		resultDTO = new ResultDTO();
	}


	@Test
	public void insert() throws Exception {
		resultDTO.setFirst(1);
//		resultDAO.insert(resultDTO);
	}

	@Test
	public void delete() throws Exception {
		resultDAO.delete();
	}

}
