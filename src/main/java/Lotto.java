import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
	
	List<Integer> lottoNumbers;
	
	Lotto(List<Integer> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
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
		List<Integer> lotto = numbers.subList(0, 6);
		Collections.sort(lotto);
		return lotto;
	}
	
	static List<Lotto> createLottoList(int howMany) {
		List<Lotto> lotto = new ArrayList<>();
		for (int i = 0; i < howMany; i++) {
			lotto.add(new Lotto(createLottoNumbers()));
		}
		return lotto;
	}
}
