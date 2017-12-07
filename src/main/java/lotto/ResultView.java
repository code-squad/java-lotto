package lotto;

import java.util.ArrayList;

public class ResultView {
	//구입 금액만큼 산 로또 티켓의 번호들을 모두 출력해주는 메소드.
	public static void printTicket(Lottos tickets) {
		for (int i = 0; i < tickets.get().size(); i++) {
			System.out.println(tickets.get().get(i).getNum());
		}
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
		System.out.println(Match.valueOf(3, false).getWinningMsg() + result.get(4) + " 개");
		System.out.println(Match.valueOf(4, false).getWinningMsg() + result.get(3) + " 개");
		System.out.println(Match.valueOf(5, false).getWinningMsg() + result.get(2) + " 개");
		System.out.println(Match.valueOf(5, true).getWinningMsg() + result.get(1) + " 개");
		System.out.println(Match.valueOf(6, false).getWinningMsg() + result.get(0) + " 개");
		System.out.println("총 수익률은 " + yield + "% 입니다.");
	}
}