package com.lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.lotto.model.strategy.NumberGenerateStrategy;

public class WinningLotto {

	private List<Integer> winningNumbers;
	private int bonus;
	private NumberGenerateStrategy ngs;

	public enum Prizes {
		NOMATCH(0, 0), MATCH3(3, 5000), MATCH4(4, 20000), MATCH5(5, 1000000), MATCH6(6, 1000000000), 
		MATCH_BONUS(5,100000000);

		private int matchCount;
		private int prize;

		private Prizes(int matchCount, int prize) {
			this.matchCount = matchCount;
			this.prize = prize;
		}

		public static Prizes valueOf(int matchCount, boolean bonus) {
			if (!bonus) {
				return Arrays.asList(Prizes.values()).stream().filter(p -> p.matchCount == matchCount).findFirst()
						.orElse(NOMATCH);
			}
			if (matchCount == 5 && bonus) {
				return MATCH_BONUS;
			}
			return NOMATCH;
		}

		public int getPrize() {
			return this.prize;
		}
		
		@Override
		public String toString() {
			if (this == Prizes.NOMATCH) {
				return "낙첨";
			}
			
			if (this == Prizes.MATCH_BONUS) {
				return "당첨 번호 5개 일치 + 보너스 번호 일치";
			}
			return String.format("당첨 번호 %d개 일치", this.matchCount);
		}
	}

	public WinningLotto(NumberGenerateStrategy ngs) {
		this.ngs = ngs;
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}

	public void setWinningNumbers() {
		this.winningNumbers = this.ngs.generateBalls();
		this.bonus = this.ngs.generateBonusBall();
	}

	public Prizes getMatchingResult(UserLotto lotto) {
		List<Integer> matchingNumbers;

		matchingNumbers = lotto.getNumbers().stream().filter(i -> this.winningNumbers.contains(i))
				.collect(Collectors.toList());
				
		return Prizes.valueOf(matchingNumbers.size(), this.isBonus(lotto));
	}	
	
	private boolean isBonus(UserLotto lotto) {
		return lotto.getNumbers().stream().anyMatch(i -> i.intValue() == this.bonus);
	}

}
