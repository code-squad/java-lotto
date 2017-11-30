package lotto;

import java.util.ArrayList;

public class ResultView {
	//시작 메시지 출력.
	public static void startMsg() {
		System.out.println("구입 금액을 입력해 주세요. (1장에 1000원 입니다.)");
	}
	//당첨번호 입력을 원하는 메시지 출력.
	public static void takeWinnerMsg() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요. 숫자 사이에는 , 와 (스페이스바)를 입력해주세요.");
	}
	//지난 주 당첨 번호를 잘못 입력했을 때, 알려주는 메소드.
	public static void errorMsg() {
		System.out.println("잘 못 입력하셨습니다.\n다시 입력해 주세요.");
	}
	//거스름돈과 로또 구입금액을 알려준다.
	public static void giveChangeMsg(int money, int change) {
		System.out.println("거스름돈 " + change + " 원을 돌려 드리겠습니다.");
		System.out.println("로또 구입 금액은 " + (money - change) + " 원 입니다.");
	}
	//구입 금액만큼 산 로또 티켓의 번호들을 모두 출력해주는 메소드.
	public static void printTicket(ArrayList<Lotto> tickets) {
		for (int i = 0; i < tickets.size(); i++) {
			System.out.println(tickets.get(i).getNum());
		}
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
