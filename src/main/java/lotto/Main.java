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
		Money money = new Money(InputView.takeMoney());		//돈을 입력 받는다.
		money.giveChange();		//1000원 미만의 거스름돈을 반환 해준다.
		int lottoTicketNum = money.buyLotto();		//몇 장의 로또 티켓을 샀는지 계산하여 lottoTicket에 넣어준다.
		
		ArrayList<Lotto> tickets = buyTicket(lottoTicketNum);		//총 입력 금액만큼의 티켓을 만들어 준다.
		
		ResultView.printTicket(tickets);		//티켓의 번호들 출력.
		
		ArrayList<Integer> winningNum = InputView.inputWinningNum();		//지난 주 당첨 번호를 입력 받는다.
		
		ArrayList<Integer> correctList = new ArrayList<Integer> ();		//티켓 별 맞은 번호 수를 저장하는 리스트를 만들어준다.
		
		for (int i = 0; i < tickets.size(); i++) {
			correctList.add(tickets.get(i).matchCount(winningNum));		//각 티켓마다 winningNum과 일치하는 수가 있는지 계산하여 몇개가 일치하는지를 리스트에 넣어줌.
		}
		
		ArrayList<Integer> result = new ArrayList<Integer> ();		//최종 결과를 저장할 리스트.
		
		for(int i = 0; i < 4; i++) {
			int findNum = i + 3;		//3, 4, 5, 6개 맞은 티켓의 수를 구하기 위한 변수.
			result.add(i, ResultView.makeResult(correctList, findNum));		//3개 맞은 횟수 ~ 6개 맞은 횟수 까지를 result 리스트에 추가해 카운트한다.
		}
		
		Money.calculateMoney(result, money.getPrice());			//번 돈과 투자한 돈을 가지고 수익률을 계산한다.
	}
}
