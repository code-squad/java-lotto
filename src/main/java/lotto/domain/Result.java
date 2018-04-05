package lotto.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.db.LottoDTO;
import lotto.db.LottoGameDAO;
import lotto.db.LottoGameDTO;
import lotto.db.ResultDAO;
import lotto.db.ResultDTO;

public class Result {
	private Map<Rank, Integer> rankResult;

	public Result(Map<Rank, Integer> rankResult) {
		this.rankResult = rankResult;
	}

	public static Result of() {
		Map<Rank, Integer> rankResult = new HashMap<>();
		rankResult.put(Rank.FIRST, 0);
		rankResult.put(Rank.SECOND, 0);
		rankResult.put(Rank.THIRD, 0);
		rankResult.put(Rank.FOURTH, 0);
		rankResult.put(Rank.FIFTH, 0);
		return new Result(rankResult);
	}

	public int rankNum(Rank rank) {
		return rankResult.get(rank);
	}

	public static ResultDTO selectResult() throws SQLException {
		ResultDAO resultDao = new ResultDAO();
		return resultDao.select();
	}

	public static ResultDTO selectResult(String inputTurnNo) throws SQLException {
		ResultDAO resultDao = new ResultDAO();
		return resultDao.select(inputTurnNo);
	}

	public void insertResult(String price, String turnNo) throws SQLException {

		calcResult(LottoProcess.selectLottos(turnNo), turnNo);
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setFirst(rankNum(Rank.FIRST));
		resultDTO.setSecond(rankNum(Rank.SECOND));
		resultDTO.setThird(rankNum(Rank.THIRD));
		resultDTO.setFourth(rankNum(Rank.FOURTH));
		resultDTO.setFifth(rankNum(Rank.FIFTH));
		resultDTO.setRevenue(calcRevenue(price));
		ResultDAO resultDao = new ResultDAO();
		resultDao.insert(resultDTO, turnNo);
	}

	public void calcResult(List<LottoDTO> lottodto, String turnNo) throws SQLException {

		LottoGameDAO lottoGameDAO = new LottoGameDAO();
		LottoGameDTO lottoGameDTO = lottoGameDAO.selectWinNo(turnNo);
		List<Integer> beforeWinLotto = calcResult(lottoGameDTO);

		int countOfMatch = 0;
		LottoProcess lottoProcess = LottoProcess.of(lottodto);
		for (int i = 0; i < lottoProcess.size(); i++) {
			countOfMatch = lottoProcess.countOfMatch(i, beforeWinLotto);
			calcResult(countOfMatch, checkMatchBonus(lottoProcess, i, lottoGameDTO.getBonus()));
		}
	}

	public List<Integer> calcResult(LottoGameDTO lottoGameDTO) {
		List<Integer> beforeWinLotto = new ArrayList<>();
		beforeWinLotto.add(lottoGameDTO.getFirst());
		beforeWinLotto.add(lottoGameDTO.getSecond());
		beforeWinLotto.add(lottoGameDTO.getThird());
		beforeWinLotto.add(lottoGameDTO.getFourth());
		beforeWinLotto.add(lottoGameDTO.getFifth());
		beforeWinLotto.add(lottoGameDTO.getSixth());
		return beforeWinLotto;
	}

	public boolean checkMatchBonus(LottoProcess lottoProcess, int i, int bonusNum) {
		if (lottoProcess.getLotto(i).haveNumber(bonusNum)) {
			return true;
		}
		return false;
	}

	public void calcResult(int countOfMatch, boolean matchBonus) {
		rankResult.replace(Rank.FIRST, compareRank(countOfMatch, Rank.FIRST, matchBonus));
		rankResult.replace(Rank.SECOND, compareRank(countOfMatch, Rank.SECOND, matchBonus));
		rankResult.replace(Rank.THIRD, compareRank(countOfMatch, Rank.THIRD, matchBonus));
		rankResult.replace(Rank.FOURTH, compareRank(countOfMatch, Rank.FOURTH, matchBonus));
		rankResult.replace(Rank.FIFTH, compareRank(countOfMatch, Rank.FIFTH, matchBonus));
	}

	public int compareRank(int countOfMatch, Rank rank, boolean matchBonus) {
		if (Rank.valueOf(countOfMatch, matchBonus) == rank) {
			return rankResult.get(rank) + 1;
		}
		return rankResult.get(rank);
	}

	public int calcRevenue(String price) {
		return (((Rank.FIRST.getWinningMoney() * rankNum(Rank.FIRST))
				+ (Rank.SECOND.getWinningMoney() * rankNum(Rank.SECOND))
				+ (Rank.THIRD.getWinningMoney() * rankNum(Rank.THIRD))
				+ (Rank.FOURTH.getWinningMoney() * rankNum(Rank.FOURTH))
				+ (Rank.FIFTH.getWinningMoney() * rankNum(Rank.FIFTH))) - Integer.parseInt(price)) / 100;
	}

}
