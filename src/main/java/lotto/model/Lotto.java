package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Lotto {
	List<Integer> numbers = null;
	private final int MIN_NUMBER = 1;
	private final int MAX_NUMBER = 45;
	protected final int LOTTOCOUNT = 6;
	protected List<Integer> inputNumberList = new ArrayList<>();

	// 생성자 입력내용 없으면 자동생성
	public Lotto() {
		numbers = new ArrayList<>();
		autoInputNumberList();
		purchaseAuto();
	}

	// 입력한 로또번호가 있을 때 그 번호에 맞게 생성
	public Lotto(String lottoNumber) {
		numbers = new ArrayList<>();
		String[] stringLottoNumbers = lottoNumber.split(", ");
		for (int i = 0; i < stringLottoNumbers.length; i++) {
			numbers.add(Integer.parseInt(stringLottoNumbers[i]));
		}
		Collections.sort(numbers);
	}

	// 로또 추첨번호들이 들어갈 리스트 생성
	private void autoInputNumberList() {
		for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
			inputNumberList.add(i);
		}
	}

	// 로또 추첨번호들이 들어간 리스트를 셔플하고 로또의 번호 숫자만큼 잘라내 로또 생성 winLottos에서는 보너스 볼까지 생성
	protected abstract void purchaseAuto();

	// 로또 번호를 스트링으로 출력
	public String getString() {
		return numbers.stream().map(i -> i.toString()).collect(Collectors.joining(", "));
	}

	// 로또들 끼리 비교하여 일치한 개수 출력
	public int compareLottoCount(Lotto lotto) {
		return (int) numbers.stream().filter(i -> lotto.matchingNumber(i)).count();
	}

	// 그 번호가 있는지 확인 (테스트용)
	public boolean matchingNumber(int number) {
		return numbers.contains(number);
	}

	// 인덱스번호로 로또번호 출력 (테스트용)
	public int getNumber(int index) {
		return numbers.get(index);
	}
}
