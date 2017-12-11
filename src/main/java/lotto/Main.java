package lotto;

import java.util.ArrayList;


public class Main {
	//입력받은 티켓의 수만큼 티켓을 만들어주는 메소드. (총 만들어진 티켓모두를 리턴한다.)
	private static Lottos buyTicket (int ticketNum) {
		Lottos lottos = new Lottos();
		for (int i = 0; i < ticketNum; i++) {
			lottos.add(new Lotto());
		}
		return lottos;
	}
	
	//===========================MAIN START===============================
	public static void main (String[] args) {
		Money money = new Money(InputView.takeMoney());		//돈을 입력 받는다.
		money.giveChange();		//1000원 미만의 거스름돈을 반환 해준다.
		int lottoTicketNum = money.buyLotto();		//몇 장의 로또 티켓을 샀는지 계산하여 lottoTicket에 넣어준다.
		
		Lottos lottos = buyTicket(lottoTicketNum);		//총 입력 금액만큼의 티켓을 만들어 준다.
		
		ResultView.printTicket(lottos);		//티켓의 번호들 출력.
		
		ArrayList<Integer> winningNum = InputView.inputWinningNum();		//지난 주 당첨 번호를 입력 받는다.
		int bonusNum = InputView.takeBonusNum();		//보너스 번호를 입력받는다.
		
		ArrayList<Match> matchList = lottos.makeMatchList(winningNum, bonusNum);
		ArrayList<MatchingResult> result = lottos.makeResult();
		
		Lottos.fillResult(matchList, result);		//당첨 번호들을 가지고 최신 result 로 채워준다.(Update해준다.)
		
		double profit = lottos.calculateMoney(result, money);		//번 돈과 투자한 돈을 가지고 수익률을 계산한다.
		
		ResultView.printResult(result);		//결과를 출력해준다. (등수 별로)
		ResultView.printProfit(profit);		//총 이익(수익률)을 출력해준다.
	}
}
