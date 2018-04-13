package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.util.StringFormatMatchUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);
	private static final String WIN_NUMBER_SPLIT_REGEX = ", |,";
	
	public static int showGetMoneyView() {
		System.out.println("구입금액을 입력해 주세요.");
		String inputValue = scanner.nextLine();
		
		if(!StringFormatMatchUtils.matchNumberFormat(inputValue)) {
			showWrongInputErrorView();
			return showGetMoneyView();
		}
		
		return Integer.parseInt(inputValue);
	}
	
	public static int showGetCustomLottoCountView() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		String inputValue = scanner.nextLine();
		
		if(!StringFormatMatchUtils.matchNumberFormat(inputValue)) {
			showWrongInputErrorView();
			return showGetCustomLottoCountView();
		}
		
		return Integer.parseInt(inputValue);
	}
	
	public static List<Lotto> showGetCustomLottoView(int customLottoCount) {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		List<String> inputValues = IntStream.range(0, customLottoCount)
				.mapToObj(count -> scanner.nextLine())
				.collect(toList());
		
		if(inputValues.stream()
				.map(StringFormatMatchUtils::matchNumbersFormat)
				.collect(reducing(Boolean::logicalAnd))
				.equals(false)) {
			showWrongInputErrorView();
			return showGetCustomLottoView(customLottoCount);
		}
		
		List<Lotto> lottos = null;
		try {
			lottos = inputValues.stream()
					.map(inputValue -> Arrays.stream(inputValue.split(WIN_NUMBER_SPLIT_REGEX))
							.map(LottoNumber::parseLottoNumber)
							.collect(toList()))
					.map(LottoNumbers::new)
					.map(lottoNumbers -> new Lotto(lottoNumbers, false))
					.collect(toList());
		} catch (IllegalArgumentException e) {
			showWrongInputErrorView();
			return showGetCustomLottoView(customLottoCount);
		}
		
		return lottos;
	}
	
	public static LottoNumber showGetBonusNumberView() {
		System.out.println("보너스 볼을 입력해주세요.");
		String inputValue = scanner.nextLine();
		
		if(!StringFormatMatchUtils.matchNumberFormat(inputValue)) {
			showWrongInputErrorView();
			return showGetBonusNumberView();
		}
		
		LottoNumber lottoNumber = null;
		try {
			lottoNumber = new LottoNumber(Integer.parseInt(inputValue));
		} catch (IllegalArgumentException e) {
			showWrongInputErrorView();
			return showGetBonusNumberView();
		}
	
		return lottoNumber;
	}
	
	public static LottoNumbers showGetWinNumbersView() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String inputValue = scanner.nextLine();
		
		if(!StringFormatMatchUtils.matchNumbersFormat(inputValue)) {
			showWrongInputErrorView();
			return showGetWinNumbersView();
		}
		
		LottoNumbers lottoNumbers = null;
		try {
			lottoNumbers = new LottoNumbers(Arrays.stream(inputValue.split(WIN_NUMBER_SPLIT_REGEX))
					.map(LottoNumber::parseLottoNumber)
					.collect(toList()));
		} catch (IllegalArgumentException e) {
			showWrongInputErrorView();
			return showGetWinNumbersView();
		}
		
		return lottoNumbers;
	}
	
	private static void showWrongInputErrorView() {
		System.out.println(" - 입력값이 잘못되었습니다.");
	}
}
