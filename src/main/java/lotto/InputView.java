package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {
	//처음에 로또를 구매할 금액을 입력 받는다.
	public static int takeMoney() {
		System.out.println("구입 금액을 입력해 주세요. (1장에 1000원 입니다.)");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	//번호를 입력받아서 (String 형태로), String형 arraylist로 변환하여 리턴해주는 메소드.
	public static ArrayList<String> inputManualNum() {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		if (input.length() == 0) {
			return null;		//빈 엔터만 입력 받았을 때는 null 리턴.
		}
		ArrayList<String> manualList = new ArrayList<String>(Arrays.asList(splitNumber(input)));
		
		return manualList;
	}
	//번호를 입력받아서 (String 형태로), int형 arraylist로 변환하여 리턴해주는 메소드.
	public static ArrayList<Integer> inputNum() {
		ArrayList<String> inputList = takeNum();		//String 형 데이터를 입력받는다.
		inputList = checkInput(inputList);			//제대로 된 데이터가 입력 되었는지 확인.
		ArrayList<Integer> winningNum = convertInput(inputList);		//String 을 Integer 형으로 변환.
		
		return winningNum;
	}
	//지난 주 당첨 번호를 입력 받는다. 입력받은 String 를 ArrayList에 넣어서 리턴한다.
	private static ArrayList<String> takeNum() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요. 숫자 사이에는 , 와 (스페이스바)를 입력해주세요.");
		Scanner scan = new Scanner(System.in);
		String inputValue = scan.nextLine();
		
		//","를 기준으로 단어를 나누어 ArrayList에 저장.
		ArrayList<String> winningList = new ArrayList<String>(Arrays.asList(splitNumber(inputValue)));
		return winningList;
	}
	//보너스 번호를 입력 받는다.
	public static int takeBonusNum() {
		System.out.println("보너스 번호를 입력해주세요.");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	//input 값이 6개가 아니면 제대로 입력될 때까지 계속해서 루프!!
	private static ArrayList<String> checkInput(ArrayList<String> input) {
		ArrayList<String> checkList = input;
		while (checkList.size() != 6) {
			System.out.println("잘 못 입력하셨습니다.\n다시 입력해 주세요.");		//에러메시지 출력.
			checkList = takeNum();
		}
		return checkList;
	}
	//문자열을 ", "를 기준으로 배열에 넣어주는 메소드.
	private static String[] splitNumber(String input) {
		return input.split(", ");
	}
	//문자열로 받은 입력값을 정수형으로 변환해주는 메소드.
	public static ArrayList<Integer> convertInput(ArrayList<String> input) {
		if ( input == null ) {
			return null;
		}
		ArrayList<Integer> output = new ArrayList<Integer> ();
		for (int i = 0; i < input.size(); i++) {
			output.add(Integer.parseInt(input.get(i)));
		}
		return output;
	}
}
