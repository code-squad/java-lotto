package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {
	//처음에 로또를 구매할 금액을 입력 받는다.
	public static int takeMoney() {
		Scanner scan = new Scanner(System.in);
		int money = scan.nextInt();
		
		return money;
	}
	//지난 주 당첨 번호를 입력 받는다.
	public static ArrayList<String> takeWinningNum() {
		Scanner scan = new Scanner(System.in);
		
		//","를 기준으로 단어를 나누어 ArrayList에 저장.
		ArrayList<String> winningList = new ArrayList<String>(Arrays.asList(splitNumber(scan.nextLine())));
		return winningList;
	}
	//input 값이 6개가 아니면 제대로 입력될 때까지 계속해서 루프!!
	public static ArrayList<String> checkInput(ArrayList<String> input) {
		while (input.size() != 6) {
			ResultView.errorMsg();
			input = InputView.takeWinningNum();
		}
		return input;
	}
	//문자열을 ", "를 기준으로 배열에 넣어주는 메소드.
	private static String[] splitNumber(String input) {
		return input.split(", ");
	}
	//문자열로 받은 입력값을 정수형으로 변환해주는 메소드.
	public static ArrayList<Integer> convertInput(ArrayList<String> input) {
		ArrayList<Integer> output = new ArrayList<Integer> ();
		for (int i = 0; i < input.size(); i++) {
			output.add(Integer.parseInt(input.get(i)));
		}
		return output;
	}
}
