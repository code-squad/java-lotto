
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
	static Scanner sc = new Scanner(System.in);
	
	static int getMoney() {
		System.out.println("구입 금액을 입력해주세요");
		int money = Integer.parseInt(sc.nextLine());
		if (money < 1000) {
			System.out.println("1000원 이상을 입력해주세요");
			return getMoney();
		}
		return money;
	}
	
	static int getHowMany(int money) {
		int howMany = money / 1000;
		return howMany;
	}
	
	static String[] getLuckyNumber() {
		System.out.println("지난 주 당첨 번호를 입력해주세요");
		String temp = sc.nextLine();
		String[] luckyNumber = temp.split(",");
		if (luckyNumber.length != 6) {
			System.out.println("1 ~ 45 중 6개의 숫자를 중복 없이 골라주세요");
			return getLuckyNumber();
		}
		sc.close();
		return luckyNumber;
	}
	
	static List<Integer> makeStringToInt(String[] number) {
		List<Integer> luckyNumber = new ArrayList<>();
		for (String temp : number) {
			luckyNumber.add(Integer.parseInt(temp));
		}
		return luckyNumber;
	}
}
