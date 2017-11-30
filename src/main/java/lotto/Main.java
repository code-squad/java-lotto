package lotto;

import java.util.ArrayList;


public class Main {
	//거스름돈을 계산하여 반환해주는 메소드.
	public static int giveChange(int money) {
		ResultView.giveChangeMsg(money, money % 1000);
		return (money - (money % 1000));
	}
	//입금된 가격만큼 산 티켓의 갯수를 반환해주는 메소드.
	public static int buyLotto(int money) {
		return (money / 1000);
	}
	//입력받은 티켓의 수만큼 티켓을 만들어주는 메소드. (총 만들어진 티켓모두를 리턴한다.)
	private static ArrayList<Lotto> buyTicket (int ticketNum, ArrayList<Lotto> tickets) {
		for (int i = 0; i < ticketNum; i++) {
			ArrayList<Integer> ticket = new ArrayList<Integer> ();
			tickets.add(new Lotto(ticket));		//자동으로 6개의 번호를 골라서 티켓을 생성한다.
		}
		return tickets;
	}
	//맞은 숫자의 갯수에 따라 최종 결과 리스트에 넣어주는 메소드.
	private static int makeResult(ArrayList<Lotto> tickets, int findNum) {
		findNum += 3;
		int count = 0;
		for (int i = 0; i < tickets.size(); i++) {
			count += howManyCorrect(tickets.get(i).getNum().get(6), findNum);
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
	//맞은 갯수 비례 금액을 계산하여 총 딴 돈을 구한다. (내가 건 돈 만큼은 뺀다.)
	private static int calculateMoney(ArrayList<Integer> result, int money) {
		int moneyResult = (result.get(0) * 5000) + (result.get(1) * 50000) + (result.get(2) * 1500000) + (result.get(3) * 2000000000) - money;
		
		return moneyResult;
	}
	//===========================MAIN START===============================
	public static void main (String[] args) {
		ResultView.startMsg();		//시작 메시지 출력.
		int money = InputView.takeMoney();		//돈을 입력 받는다.
		money = giveChange(money);		//1000원 미만의 거스름돈을 반환 해준다.
		int lottoTicketNum = buyLotto(money);		//몇 장의 로또 티켓을 샀는지 계산하여 lottoTicket에 넣어준다.
		
		ArrayList<Lotto> tickets = new ArrayList<Lotto> ();	
		tickets = buyTicket(lottoTicketNum, tickets);		//총 입력 금액만큼의 티켓을 만들어 준다.
		
		ResultView.printTicket(tickets);		//티켓의 번호들 출력.
		
		ResultView.takeWinnerMsg();
		
		ArrayList<String> winningString = InputView.takeWinningNum();		//지난 주 당첨 번호를 입력받는다. (String type)
		winningString = InputView.checkInput(winningString);			//지난 주 당첨 번호가 제대로 입력될 때까지 다시 입력 받는다.
		ArrayList<Integer> winningNum = InputView.convertInput(winningString);		//String 타입의 지난 당첨번호를 int 타입으로 변경한다.
		
		for (int i = 0; i < tickets.size(); i++) {
			tickets.get(i).matchCount(winningNum);		//각 티켓마다 winningNum과 일치하는 수가 있는지 계산하여 티켓 맨 뒤에 일치하는 수를 추가해준다.
		}
		
		ArrayList<Integer> result = new ArrayList<Integer> ();
		
		for(int i = 0; i < 4; i++) {
			result.add(i, makeResult(tickets, i));		//3개 맞은 횟수 ~ 6개 맞은 횟수 까지를 result 리스트에 추가해 카운트한다.
		}
		
		int earnMoney = calculateMoney(result, money);		//총 번 돈을 계산한다.
		int yield = (earnMoney/money) * 100;			//건 돈 비례 번 돈을 계산한다. (수익률을 계산한다.)
		ResultView.printResult(result, yield);		//결과를 출력해준다.
	}
}
