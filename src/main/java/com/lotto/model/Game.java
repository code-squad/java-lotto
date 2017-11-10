package com.lotto.model;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.lotto.model.WinningLotto.Prizes;

public class Game {

	private List<UserLotto> userLottos;
	private WinningLotto winningLotto;

	public Game(List<UserLotto> userLottos, WinningLotto winningLotto) {
		this.userLottos = userLottos;
		this.winningLotto = winningLotto;
	}
	
	public void initialize() {
		this.winningLotto.setWinningNumbers();
		this.userLottos.stream().forEach(u -> u.setNumbers());
	}
	
	public String getResultsByString() {
		StringBuffer sbf = new StringBuffer();
		Map<Prizes, Integer> prizesMap = getPrizesCount();
		sbf.append(String.format("당신의 수령 당첨금은 %d원 입니다.\n", calculateSum()));
		sbf.append("=================================\n");
		
		prizesMap.keySet().stream().forEach(k -> {
			sbf.append(k.toString() + " : ");
			sbf.append(prizesMap.get(k) + "개\n");
		});
		
		return sbf.toString();
	}

	private int calculateSum() {
		return this.userLottos.stream().mapToInt(u -> this.winningLotto.getMatchingResult(u).getPrize()).sum();
	}

	private Map<Prizes, Integer> getPrizesCount() {
		Map<Prizes, Integer> maps = Maps.newEnumMap(Prizes.class);

		this.userLottos.stream().forEach(u -> {
			Prizes prizes = this.winningLotto.getMatchingResult(u);
			if (maps.containsKey(prizes)) {
				maps.put(prizes, maps.get(prizes) + 1);
			} else
				maps.put(prizes, 1);
		});
		return maps;
	}

}
