package lotto.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lotto.db.LottoDAO;
import lotto.db.LottoDTO;
import lotto.db.LottoGameDAO;
import lotto.view.Input;

public class LottoProcess {
	public static final int MAXNUM_RANGE = 45;
	private List<Lotto> lottos;

	public LottoProcess(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static LottoProcess of(int sheets, String inputUserNum) {
		List<Lotto> manualNumbers = Input.inputUserNum(inputUserNum);
		List<Lotto> lottos = new ArrayList<>();
		lottos.addAll(manualNumbers);
		lottos.addAll(makeLottos(sheets - manualNumbers.size(), makeNumbers()));
		return new LottoProcess(lottos);
	}

	public static LottoProcess of(List<LottoDTO> lottoDTO) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < lottoDTO.size(); i++) {
			lottos.add(UserLotto.ofInteger(lottoDTO.get(i).getNumbers()));
		}
		return new LottoProcess(lottos);
	}

	public static LottoProcess of(int sheets) {
		List<Lotto> lottos = new ArrayList<>();
		lottos.addAll(makeLottos(sheets, makeNumbers()));
		return new LottoProcess(lottos);
	}

	public void insertLottos(String turnNo) throws SQLException {

		insertWinLotto(turnNo);

		List<LottoDTO> lottodto = getAllLottos();
		LottoDAO lottoDAO = new LottoDAO();
		for (int i = 0; i < lottos.size(); i++) {
			lottoDAO.insert(turnNo, lottodto.get(i));
		}
	}

	public void insertWinLotto(String turnNo) throws SQLException {
		LottoGameDAO lottogameDAO = new LottoGameDAO();
		lottogameDAO.insertWinNo(turnNo, LottoProcess.of(1).getLottoDTO(0));
	}

	public static List<LottoDTO> selectLottos(String turnNo) throws SQLException {
		List<LottoDTO> lottodto = new ArrayList<>();
		LottoDAO lottoDao = new LottoDAO();
		lottodto = lottoDao.select(turnNo);
		return lottodto;
	}

	public static List<Integer> makeNumbers() {
		List<Integer> numberRange = new ArrayList<>();
		for (int i = 1; i < MAXNUM_RANGE; i++) {
			numberRange.add(i);
		}
		return numberRange;
	}

	public static List<Lotto> makeLottos(int sheets, List<Integer> numberRange) {
		List<Lotto> lottos = new ArrayList<>();
		if (sheets == 1) {
			lottos.add(AutoLotto.ofWinLotto(numberRange, sheets));
			return lottos;
		}
		for (int i = 0; i < sheets; i++) {
			lottos.add(AutoLotto.of(numberRange));
		}
		return lottos;
	}

	public int size() {
		return lottos.size();
	}

	public Lotto getLotto(int i) {
		return lottos.get(i);
	}

	public int countOfMatch(int i, List<Integer> beforeWinLotto) {
		return getLotto(i).countOfMatch(beforeWinLotto);
	}

	public List<LottoDTO> getAllLottos() {
		List<LottoDTO> lottos = new ArrayList<>();
		for (int i = 0; i < this.lottos.size(); i++) {
			LottoDTO lotto = new LottoDTO();
			lotto.setNumbers(getLotto(i).getNumbers());
			lottos.add(lotto);
		}
		return lottos;
	}

	public LottoDTO getLottoDTO(int i) {
		return getAllLottos().get(i);
	}

	public static LottoProcess getLottoProcess(String manualNumber, int sheets) {
		if (manualNumber.isEmpty()) {
			return LottoProcess.of(sheets);
		}
		return LottoProcess.of(sheets, manualNumber);
	}

}
