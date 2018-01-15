package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputView {
	private static final Logger log = LoggerFactory.getLogger(InputView.class);
	
	public static int takeMoney() {
		log.info("구입 금액을 입력해 주세요. (1장에 1000원 입니다.)");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	public static List<String> inputManualNum(String inputManualNum) {
		if (inputManualNum.length() == 0) {
			List<String> manualList = new ArrayList<String> ();
			return manualList;
		}
		
		//List<String> manualList = new ArrayList<String>(Arrays.asList(splitNumber(inputManualNum)));
		List<String> manualList = splitLotto(inputManualNum);
		return manualList;
	}

	public static List<Integer> inputNum() {
		List<String> inputList = takeNum();
		inputList = checkInput(inputList);
		List<Integer> winningNum = convertInput(inputList);
		
		return winningNum;
	}

	private static ArrayList<String> takeNum() {
		log.info("지난 주 당첨 번호를 입력해 주세요. 숫자 사이에는 , 와 (스페이스바)를 입력해주세요.");
		Scanner scan = new Scanner(System.in);
		String inputValue = scan.nextLine();
		
		//","를 기준으로 단어를 나누어 ArrayList에 저장.
		ArrayList<String> winningList = new ArrayList<String>(Arrays.asList(splitNumber(inputValue)));
		return winningList;
	}

	public static int takeBonusNum() {
		log.info("보너스 번호를 입력해주세요.");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	private static List<String> checkInput(List<String> input) {
		List<String> checkList = input;
		while (checkList.size() != 6) {
			log.info("잘 못 입력하셨습니다.\n다시 입력해 주세요.");
			checkList = takeNum();
		}
		return checkList;
	}

	private static List<String> splitLotto(String input) {
		List<String> lottoList = new ArrayList<String> ();
		
		String[] values = input.split("\n");
		List<String> result = new ArrayList<String> ();
		for (String value : values) {
			result.add(value.trim());
		}
		
		for (String value : result) {
			String[] splited = value.split(",");
			lottoList.addAll(Arrays.asList(splited));
		}
//		List<String> lottoList = new ArrayList<String>(Arrays.asList(input.split("\n")));
//		
//		
//		for (int i = 0; i < lottoList.size(); i++) {
//			lottoList.set(i, lottoList.get(i).trim());
//		}
//		
//		for (String strNum : lottoList) {
//			result.addAll(Arrays.asList(splitNumber(strNum)));
//		}
//		
		for (int i = 0; i < lottoList.size(); i++) {
			log.error(lottoList.get(i));
		}
		return lottoList;
	}
	
	private static String[] splitNumber(String input) {
		return input.split(",");
	}

	public static List<Integer> convertInput(List<String> input) {
		List<Integer> output = new ArrayList<Integer> ();
		for (int i = 0; i < input.size(); i++) {
			output.add(Integer.parseInt(input.get(i)));
		}
		return output;
	}
}
