package Lotto;
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
	//문자열을 ", "를 기준으로 배열에 넣어주는 메소드.
	public static String[] splitNumber(String input) {
		return input.split(", ");
	}
}
