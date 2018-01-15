package lotto;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultView {
	private static final Logger log = LoggerFactory.getLogger(ResultView.class);
	
	//구입 금액만큼 산 로또 티켓의 번호들을 모두 출력해주는 메소드.
	public static void printTicket(Lottos tickets) {
		for (int i = 0; i < tickets.get().size(); i++) {
			log.info(tickets.get().get(i).getStringNums());
		}
	}
	public static void printAutoOrManual(int manualNum, int autoNum) {
		log.info("수동으로 " + manualNum + "장, 자동으로 " + autoNum + "장 만들었습니다.");
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
	public static void printResult(ArrayList<MatchingResult> result) {
		for (int i = 0; i < result.size(); i++) {
			MatchingResult matchingResult = result.get(i);
			log.info(matchingResult.returnMsg() + matchingResult.returnCount() + " 개");
		}
	}
	//총 수익률을 계산해주는 메소드.
	public static void printProfit(double yield) {
		log.info("총 수익률은 " + yield + "% 입니다.");
	}
}