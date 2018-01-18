import java.util.ArrayList;
import java.util.List;

public class WinningLotto extends Lotto{

	WinningLotto(List<Integer> numbers) {
		super(numbers);
	}
	
	static List<Integer> getWinningLotto(String winningLottoNo) {
		String[] splittedInputNum = makeArray(winningLottoNo);
		List<Integer> winningLotto = new ArrayList<>();
		for (String number : splittedInputNum) {
			winningLotto.add(Integer.parseInt(number));
		}
		if ( !checkLottoNumRange(winningLotto) ) {
			return getWinningLotto(winningLottoNo);
		}
		return winningLotto;
	}
	
	private static String[] makeArray(String inputNum) {
		String[] splittedInputNum = inputNum.split(",");
		if (splittedInputNum.length != 6) {
			System.out.println("1 ~ 45 중 6개의 숫자를 골라주세요!");
			return makeArray(Input.inputWinningLotto());
		}
		return splittedInputNum;
	}
	
	private static boolean checkLottoNumRange(List<Integer> winningLotto) {
		for (int numbers : winningLotto) {
			if (!(UserLotto.makeNumbers().contains(numbers))) {
				return false;
			}
		}
		return true;
	}
}
