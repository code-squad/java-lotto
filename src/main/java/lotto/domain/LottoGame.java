package lotto.domain;

import java.util.*;
import java.util.stream.IntStream;

public class LottoGame {
	private static final int LOTTO_PRICE = 1000;
	
	public int play(int money) {
		// 로또 생성
		int lottoNum = money / 1000;
		List<Lotto> lottos = new ArrayList<>();
		IntStream.range(0, lottoNum)
				.forEach(n -> lottos.add(new Lotto(1,3,5,14,22,45)));
		
		// 당첨통계 내기
		int[] winNumbers = {1,2,3,4,5,6};
		Map<Integer, Integer> winResult = new HashMap<>();
		winResult.put(0, 0);
		winResult.put(1, 0);
		winResult.put(2, 0);
		winResult.put(3, 0);
		winResult.put(4, 0);
		winResult.put(5, 0);
		winResult.put(6, 0);
		
		for(Lotto lotto : lottos) {
			int[] numbers = lotto.getNumbers();
			int winCount = 0;
			for(int number : numbers) {
				for(int winNumber : winNumbers) {
					if(winNumber == number) {
						winCount++;
						break;
					}
				}
			}
			winResult.put(winCount, winResult.get(winCount) + 1);
		}
		
		// 총 수익률 구하기
		int sum = winResult.get(3) * 5000
				+ winResult.get(4) * 50000
				+ winResult.get(5) * 1500000
				+ winResult.get(6) * 2000000000;
		
		return sum / money * 100;
	}
}
