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
	public static ArrayList<Lotto> buyTicket (int ticketNum, ArrayList<Lotto> tickets) {
		for (int i = 0; i < ticketNum; i++) {
			ArrayList<Integer> ticket = new ArrayList<Integer> ();
			tickets.add(new Lotto(Lotto.selectAutoNum(ticket)));		//자동으로 6개의 번호를 골라서 티켓을 생성한다.
		}
		return tickets;
	}
	//input 값이 6개가 아니면 제대로 입력될 때까지 계속해서 루프!!
	public static ArrayList<String> checkInput(ArrayList<String> input) {
		while (input.size() != 6) {
			ResultView.errorMsg();
			input = InputView.takeWinningNum();
		}
		return input;
	}
	//문자열로 받은 입력값을 정수형으로 변환해주는 메소드.
	public static ArrayList<Integer> convertInput(ArrayList<String> input) {
		ArrayList<Integer> output = new ArrayList<Integer> ();
		for (int i = 0; i < input.size(); i++) {
			output.add(Integer.parseInt(input.get(i)));
		}
		return output;
	}
	//뽑은 로또 번호들 중, 당첨 숫자가 있는지 체크하는 메소드.
	public static ArrayList<Integer> checkTickets(ArrayList<Lotto> tickets, ArrayList<Integer> winningNum) {
		ArrayList<Integer> correctList = new ArrayList<Integer> ();
		for (int i = 0; i < tickets.size(); i++) {
			correctList.add(checkOneTicket(tickets.get(i).getNum(), winningNum));
		}
		return correctList;
	}
	//한 티켓 안에 몇개의 맞는 번호가 있는지 확인하고, 맞은 갯수를 리턴하는 메소드.
	public static int checkOneTicket(ArrayList<Integer> ticket, ArrayList<Integer> winningNum) {
		int count = 0;
		for (int i = 0; i < ticket.size(); i++) {
			count = countNumExist(ticket.get(i), winningNum, count);
		}
		return count;
	}
	//한 티켓 안의 한 숫자가 당첨 숫자중에 있는 숫자인지 파악하고, 있다면 count값을 증가시켜 리턴하는 메소드.
	public static int countNumExist(int ticketNum, ArrayList<Integer> winningNum, int count) {
		if(winningNum.contains(ticketNum)) {
			count++;
		}
		return count;
	}
	//맞은 숫자의 갯수에 따라 최종 결과 리스트에 넣어주는 메소드.
	public static int makeResult(ArrayList<Integer> correct, int findNum) {
		findNum += 3;
		int count = 0;
		for (int i = 0; i < correct.size(); i++) {
			count = howManyCorrect(correct, findNum, count, i);
		}
		return count;
	}
	//findNum (3 ~ 6) 개 맞은 적이 몇 번 있는지 count를 이용해 세고, count를 리턴하는 메소드.
	public static int howManyCorrect(ArrayList<Integer> correct, int findNum, int count, int i) {
		if(correct.get(i) == findNum) {
			count++;
		}
		return count;
	}
	//맞은 갯수 비례 금액을 계산하여 총 딴 돈을 구한다. (내가 건 돈 만큼은 뺀다.)
	public static int calculateMoney(ArrayList<Integer> result, int money) {
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
		ArrayList<Integer> winningNum = convertInput(winningString);		//String 타입의 지난 당첨번호를 int 타입으로 변경한다.
		
		ArrayList<Integer> correctList = checkTickets(tickets, winningNum);		//correctList 생성 후, 각 티켓마다의 맞은 갯수를 저장.
		
		ArrayList<Integer> result = new ArrayList<Integer> ();
		
		for(int i = 0; i < 4; i++) {
			result.add(i, makeResult(correctList, i));		//3개 맞은 횟수 ~ 6개 맞은 횟수 까지를 result 리스트에 추가해 카운트한다.
		}
		
		int earnMoney = calculateMoney(result, money);		//총 번 돈을 계산한다.
		int yield = (earnMoney/money) * 100;			//건 돈 비례 번 돈을 계산한다. (수익률을 계산한다.)
		ResultView.printResult(result, yield);		//결과를 출력해준다.
	}
}
