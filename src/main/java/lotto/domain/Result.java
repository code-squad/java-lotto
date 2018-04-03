package lotto.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.db.LottoDAO;
import lotto.db.LottoDTO;
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

	public void insertResult(String price, String bonusNum, String beforeWinLotto) throws SQLException { // insert
		calcResult(LottoProcess.selectLottos(), bonusNum, beforeWinLotto);
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setFirst(rankNum(Rank.FIRST));
		resultDTO.setSecond(rankNum(Rank.SECOND));
		resultDTO.setThird(rankNum(Rank.THIRD));
		resultDTO.setFourth(rankNum(Rank.FOURTH));
		resultDTO.setFifth(rankNum(Rank.FIFTH));
		resultDTO.setRevenue(calcRevenue(price));
		ResultDAO resultDao = new ResultDAO();
		resultDao.insert(resultDTO);
	}

	public void calcResult(List<LottoDTO> lottodto, String bonusNum, String beforeWinLotto) {

		int countOfMatch = 0;
		LottoProcess lottoProcess = LottoProcess.of(lottodto);
		for (int i = 0; i < lottoProcess.size(); i++) {
			countOfMatch = lottoProcess.countOfMatch(i, beforeWinLotto);
			calcResult(countOfMatch, checkMatchBonus(lottoProcess, i, bonusNum));
		}
	}

	public boolean checkMatchBonus(LottoProcess lottoProcess, int i, String bonusNum) {
		if (lottoProcess.getLotto(i).haveNumber(Integer.parseInt(bonusNum))) {
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
