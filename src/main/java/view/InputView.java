package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Money;

public class InputView {

	public Scanner sc = null;
	
	public InputView(Scanner scanner) {
		this.sc  = scanner;
	}
	
	public void endConsole() {
		this.sc.close();
	}
	
	public void getMoney(Money money) {
		System.out.println("구입금액을 입력해 주세요.");
		money.setMoney(sc.nextInt());
	}

	public String chooseType() {
		System.out.println("로또 방식 선택 [입력은 자동 or 수동]");
		return sc.next();
	}

	public List<String> getLottoNumbers(Money money) {
		System.out.println("로또 번호를 입력해 주세요. [예: 1, 2, 3, 4, 5, 6]");
		List<String> lottoNumbers = new ArrayList<String>();
		sc.skip("[\\r\\n]+");
		for(int i=0; i < money.coutTicket(); i++) {
			lottoNumbers.add(sc.nextLine());
		}
		System.out.println(lottoNumbers);
		return lottoNumbers;
	}
	
	public String getCommand() {
		System.out.println("명령어를 입력하세요.[lottery:로또 당첨번호]");
		return sc.next();
	}
	
}
