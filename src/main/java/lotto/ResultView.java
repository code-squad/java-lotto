package lotto;

import java.util.ArrayList;

public class ResultView {
	//구입 금액만큼 산 로또 티켓의 번호들을 모두 출력해주는 메소드.
	public static void printTicket(ArrayList<Lotto> tickets) {
		for (int i = 0; i < tickets.size(); i++) {
			System.out.println(tickets.get(i).getNum());
		}
	}
	//지난 주 당첨 번호를 잘못 입력했을 때, 알려주는 메소드.
	public static void errorMsg() {
		System.out.println("잘 못 입력하셨습니다.\n다시 입력해 주세요.");
	}
	//맞은 숫자의 갯수에 따라 최종 결과 리스트에 넣어주는 메소드.
	public static int makeResult(ArrayList<Integer> correct, int findNum) {
		int count = 0;
		for (int i = 0; i < correct.size(); i++) {
			count += howManyCorrect(correct.get(i), findNum);
		}
		return count;
	}
	//findNum 이 있으면 1 리턴, 없으면 0 리턴하는 메소드. 리턴값을 가지고 상위 메소드에서 count값을 증가시킴.
	private static int howManyCorrect(int correct, int findNum) {
		if(correct == findNum) {
			return 1;
		}
		return 0;
	}
	//맞은 번호의 갯수만큼 결과를 출력해주는 메소드.
	public static void printResult(ArrayList<Integer> result, int yield) {
		System.out.println("3개 일치 (5000원) : " + result.get(0) + " 개");
		System.out.println("4개 일치 (50000원) : " + result.get(1) + " 개");
		System.out.println("5개 일치 (1500000원) : " + result.get(2) + " 개");
		System.out.println("6개 일치 (2000000000원) : " + result.get(3) + " 개");
		System.out.println("총 수익률은 " + yield + "% 입니다.");
	}
}
