package lotto;

import java.util.ArrayList;


public class Main {
	//제대로 된 번호를 입력받는 만큼 수동번호 티켓을 만들어주는 메소드. (총 만들어진 티켓모두를 리턴한다.)
	private static Lottos buyManualTicket (int ticketNum) {
		System.out.println("수동으로 구매하실 번호를 입력해 주세요. 숫자 사이에는 ,와 (스페이스바)를 입력해주세요.");
		System.out.println("수동 입력이 끝나면 'ENTER'를 눌러주세요.");
		Lottos lottos = new Lottos();
		ArrayList<String> input = new ArrayList<String> ();
		
		while (input != null && ticketNum > 0) {
			input = InputView.inputManualNum();		//수동 번호를 입력 받는다.(String형으로)
			lottos = addManualLotto(input, lottos);		//수동 로또를 추가한다.
			ticketNum--;		//1장 만들고 난 뒤, 티켓 수를 1 줄인다.
		}
		return lottos;
	}
	//수동 번호 로또를 추가해주는 메소드.
	private static Lottos addManualLotto(ArrayList<String> input, Lottos lottos) {
		if (input != null) {
			lottos.add(new Lotto(InputView.convertInput(input)));
			return lottos;
		}
		return lottos;
	}
	//입력받은 티켓의 수만큼 자동번호 티켓을 만들어주는 메소드. (총 만들어진 티켓모두를 리턴한다.)
	private static Lottos buyAutoTicket (Lottos lottos, int ticketNum) {
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
		
		Lottos lottos = buyManualTicket(lottoTicketNum);		//수동으로 번호를 입력받아 티켓을 만든다.
		int manualTicketNum = lottos.get().size();		//수동으로 만든 티켓의 갯수.
		lottoTicketNum = lottoTicketNum - manualTicketNum;		//수동으로 만든만큼의 티켓 갯수를 뺴준다.
		
		ResultView.printAutoOrManual(manualTicketNum, lottoTicketNum);		//자동이 몇장, 수동이 몇장인지 알려주는 메세지 출력.
		
		lottos = buyAutoTicket(lottos, lottoTicketNum);		//남은 티켓 수만큼 자동 티켓을 만들어 준다.
		
		ResultView.printTicket(lottos);		//티켓의 번호들 출력.
		
		ArrayList<Integer> winningNum = InputView.inputNum();		//지난 주 당첨 번호를 입력 받는다.
		int bonusNum = InputView.takeBonusNum();		//보너스 번호를 입력받는다.
		
		ArrayList<Match> matchList = lottos.makeMatchList(winningNum, bonusNum);
		ArrayList<MatchingResult> result = lottos.makeResult();
		
		Lottos.fillResult(matchList, result);		//당첨 번호들을 가지고 최신 result 로 채워준다.(Update해준다.)
		
		double profit = lottos.calculateMoney(result, money);		//번 돈과 투자한 돈을 가지고 수익률을 계산한다.
		
		ResultView.printResult(result);		//결과를 출력해준다. (등수 별로)
		ResultView.printProfit(profit);		//총 이익(수익률)을 출력해준다.
	}
}
