package lotto;

import java.util.ArrayList;


public class Main {
	//입력받은 티켓의 수만큼 티켓을 만들어주는 메소드. (총 만들어진 티켓모두를 리턴한다.)
	private static ArrayList<Lotto> buyTicket (int ticketNum) {
		ArrayList<Lotto> tickets = new ArrayList<Lotto> ();	
		for (int i = 0; i < ticketNum; i++) {
			tickets.add(new Lotto());		//자동으로 6개의 번호를 골라서 티켓을 생성한다.
		}
		return tickets;
	}
	//===========================MAIN START===============================
	public static void main (String[] args) {
		ResultView.startMsg();		//시작 메시지 출력.
		int money = InputView.takeMoney();		//돈을 입력 받는다.
		money = Money.giveChange(money);		//1000원 미만의 거스름돈을 반환 해준다.
		int lottoTicketNum = Money.buyLotto(money);		//몇 장의 로또 티켓을 샀는지 계산하여 lottoTicket에 넣어준다.
		
		ArrayList<Lotto> tickets = buyTicket(lottoTicketNum);		//총 입력 금액만큼의 티켓을 만들어 준다.
		
		ResultView.printTicket(tickets);		//티켓의 번호들 출력.
		
		ResultView.takeWinnerMsg();			//지난 주 당첨 번호를 입력하라는 메시지 출력.
		
		ArrayList<String> winningString = InputView.takeWinningNum();		//지난 주 당첨 번호를 입력받는다. (String type)
		winningString = InputView.checkInput(winningString);			//지난 주 당첨 번호가 제대로 입력될 때까지 다시 입력 받는다.
		ArrayList<Integer> winningNum = InputView.convertInput(winningString);		//String 타입의 지난 당첨번호를 int 타입으로 변경한다.
		
		for (int i = 0; i < tickets.size(); i++) {
			tickets.get(i).matchCount(winningNum);		//각 티켓마다 winningNum과 일치하는 수가 있는지 계산하여 티켓 맨 뒤에 일치하는 수를 추가해준다.
		}
		
		ArrayList<Integer> result = new ArrayList<Integer> ();
		
		for(int i = 0; i < 4; i++) {
			int findNum = i + 3;
			result.add(i, ResultView.makeResult(tickets, findNum));		//3개 맞은 횟수 ~ 6개 맞은 횟수 까지를 result 리스트에 추가해 카운트한다.
		}
		
		Money.calculateMoney(result, money);			//번 돈과 투자한 돈을 가지고 수익률을 계산한다.
	}
}
