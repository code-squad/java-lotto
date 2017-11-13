package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger; //slf4j는 인터페이스
import org.slf4j.LoggerFactory;

public class Lotto {
	int commonCount = 0;
	boolean isBonus = false;
	List <Integer> lotto;
	
	//자식 클래스의 supper(); 용
	public Lotto() {}
	
	public int getCommonCount() {
		return commonCount;
	}
	//출력용
	public List<Integer> getList() {
		return lotto;
	}
	//test용
	public void setList(List<Integer> list) {
		this.lotto = list;
	}
	
	/******************
	 * 포비 팩토리 메서드 예
	 * 초기화 메소드를 밖에서 부르지 말고 생성자에 초기화 값 보내주기
	 * ***************/
	private Lotto(List<Integer> lotto){
		this.lotto = lotto;
	}

	private static List<Integer> makeLotto() {
		List<Integer> range = IntStream.range(1, 45).boxed().collect(Collectors.toList());
		Collections.shuffle(range);
		List<Integer> lotto = range.subList(0, 6); //API를 찾아보기
		Collections.sort(lotto);
		return lotto;
	}
	//일이 2개라서 makeLotto()랑 분리한 것
	public static Lotto of() {
		return new Lotto(makeLotto());
	}
/*	
	public void makeLotto() {
		list = new ArrayList<>();
		List<Integer> range = IntStream.range(1, 45).boxed().collect(Collectors.toList());
		Collections.shuffle(range);
		for(int i=0; i < 6; i++) {
			list.add(range.get(i));
		}
		Collections.sort(list);
	}	
*/	
	private static List<Integer> makeManualLotto(String manualLotto) {
		List<Integer> lotto = new ArrayList<>();
		for(String num : manualLotto.split(",")) {
			lotto.add(Integer.parseInt(num.trim()));
		}
		Collections.sort(lotto);
		return lotto;
	}
	
	public static Lotto of(String manualLotto) {
		return new Lotto(makeManualLotto(manualLotto));
	}
	
	public void addCommonCount(int num) {
		commonCount += num;
	}
	
	//getList() 대신! 이게 객체지향적 사고
	public boolean hasNum(int num) {
		return lotto.contains(num);
	}
	
	public boolean isBonusCommon(int bonus) {
		return lotto.contains(bonus); 
	}
	//lotto.getCommonCount()를 하지 않기 위해 메소드를 Lottos에서 Lotto로 옮김 
	public Prize getPrize(int bonus) {
		return Prize.valueOf(getCommonCount(), isBonusCommon(bonus));
	}
	
	public int getPrice(int bonus) {
		return getPrize(bonus).getPrice();
	}
}