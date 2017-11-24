import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
	
	private static List<Integer> makeNumber() {
		List<Integer> number = new ArrayList<>();
		for (int i = 1; i <= 45; i++) {
			number.add(i);
		}
		return number;
	}
	
	private static List<Integer> shuffleNumber(List<Integer> number) {
		Collections.shuffle(number);
		return number;
	}
	
	private static List<Integer> extractNumber(List<Integer> number) {
		List<Integer> myNumber = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			myNumber.add(number.get(i));
		}
		return myNumber;
	}
	
	private static List<Integer> sortNumber(List<Integer> myNumber) {
		Collections.sort(myNumber);
		return myNumber;
	}
	
	static List<List<Integer>> makeNumberSet(int howMany) {
		List<List<Integer>> numberSet = new ArrayList<>();
		List<Integer> number = makeNumber();
		for (int i = 0; i < howMany; i++) {
			List<Integer> shuffledNumber = shuffleNumber(number);
			List<Integer> myNumber = extractNumber(shuffledNumber);
			List<Integer> sortedNumber = sortNumber(myNumber);
			numberSet.add(sortedNumber);
		}
		return numberSet;
	}
}
