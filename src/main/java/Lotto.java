import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
	
	List<Integer> numbers;
	
	Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	int makeMatchingCount(List<Integer> luckyNumbers) {
		int matchingCount = 0;
		for (Integer number : luckyNumbers) {
			if (this.numbers.contains(number)) {
				matchingCount++;
			}
		}
		return matchingCount;
	}
	
	boolean makeMatchingBonusTag(List<Integer> luckyNumbers, int bonusNumber) {
		boolean matchingBonusTag = false;
		for (int i = 0; i < luckyNumbers.size(); i++) {
			if (this.numbers.contains(bonusNumber)) {
				matchingBonusTag = true;
			}
		}
		return matchingBonusTag;
	}

	static List<Integer> makeNumbers() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i <= 45; i++) {
			numbers.add(i);
		}
		return numbers;
	}
	
	static List<Integer> createLottoNumbers() {
		List<Integer> numbers = makeNumbers();
		Collections.shuffle(numbers);
		List<Integer> lotto = numbers.subList(0, 6);
		Collections.sort(lotto);
		return lotto;
	}
	
	static List<Lotto> createLottos(int howManyManual, int howManyAuto) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < howManyManual; i++) {
			lottos.add(new Lotto(Input.inputManualLotto()));
		}
		for (int i = 0; i < howManyAuto; i++) {
			lottos.add(new Lotto(createLottoNumbers()));
		}
		return lottos;
	}
}
