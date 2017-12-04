import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLotto extends Lotto {

	UserLotto(List<Integer> numbers) {
		super(numbers);
	}

	int makeMatchingCount(List<Integer> winningLotto) {
		int matchingCount = 0;
		for (Integer number : winningLotto) {
			if (this.numbers.contains(number)) {
				matchingCount++;
			}
		}
		return matchingCount;
	}
	
	boolean makeMatchingBonusTag(int bonusNumber) {
		return this.numbers.contains(bonusNumber);
	}

	static List<Integer> makeNumbers() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i <= 45; i++) {
			numbers.add(i);
		}
		return numbers;
	}
	
	private static List<Integer> createLottoNumbers() {
		List<Integer> numbers = makeNumbers();
		Collections.shuffle(numbers);
		List<Integer> userLotto = numbers.subList(0, 6);
		Collections.sort(userLotto);
		return userLotto;
	}
	
	static List<UserLotto> createLottos(int howManyManual, int howManyAuto) {
		List<UserLotto> lottos = new ArrayList<>();
		for (int i = 0; i < howManyManual; i++) {
			lottos.add(new UserLotto(Input.inputManualLotto()));
		}
		for (int i = 0; i < howManyAuto; i++) {
			lottos.add(new UserLotto(createLottoNumbers()));
		}
		return lottos;
	}
}
