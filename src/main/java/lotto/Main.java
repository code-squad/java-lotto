package lotto;

import java.util.ArrayList;


public class Main {
	//제대로 된 번호를 입력받는 만큼 수동번호 티켓을 만들어주는 메소드. (총 만들어진 티켓모두를 리턴한다.)
	private static Lottos buyManualTicket (int ticketNum) {
		System.out.println("수동으로 구매하실 번호를 입력해 주세요. 숫자 사이에는 ,와 (스페이스바)를 입력해주세요.");
		System.out.println("수동 입력이 끝나면 'ENTER'를 눌러주세요.");
		Lottos lottos = new Lottos();
		int count = ticketNum;
		ArrayList<String> input = new ArrayList<String> ();
		
		do {
			input = InputView.inputManualNum();		//수동 번호를 입력 받는다.(String형으로)
			lottos = addManualLotto(input, lottos);		//수동 로또를 추가한다.
			count--;	
		}while (!input.isEmpty() && count > 0);
		return lottos;
	}
	//수동 번호 로또를 추가해주는 메소드.
	private static Lottos addManualLotto(ArrayList<String> input, Lottos lottos) {
		if (!input.isEmpty()) {
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
		
		int lottoTicketNum = money.buyLotto();
		
		Lottos lottos = buyManualTicket(lottoTicketNum);		//수동으로 번호를 입력받아 티켓을 만든다.
		int manualTicketNum = lottos.get().size();		//수동으로 만든 티켓의 갯수.
		
		lottoTicketNum = lottoTicketNum - manualTicketNum;
		ResultView.printAutoOrManual(manualTicketNum, lottoTicketNum);
		
		lottos = buyAutoTicket(lottos, lottoTicketNum);		//남은 티켓 수만큼 자동 티켓을 만들어 준다.
		
		ResultView.printTicket(lottos);
		
		ArrayList<Integer> winningNum = InputView.inputNum();		//지난 주 당첨 번호를 입력 받는다.
		int bonusNum = InputView.takeBonusNum();
		WinningLotto winningLotto = new WinningLotto(winningNum, bonusNum);
		
		ArrayList<Match> matchList = lottos.makeMatchList(winningLotto);
		ArrayList<MatchingResult> result = lottos.makeResult();
		
		Lottos.fillResult(matchList, result);		//당첨 번호들을 가지고 최신 result 로 채워준다.(Update해준다.)
		
		double profit = lottos.calculateMoney(result, money);		//번 돈과 투자한 돈을 가지고 수익률을 계산한다.
		
		ResultView.printResult(result);
		ResultView.printProfit(profit);
	}
}
