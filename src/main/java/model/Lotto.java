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
	List <Integer> list = null;
	

	public int getCommonCount() {
		return commonCount;
	}
	//출력용
	public List<Integer> getList() {
		return list;
	}
	//test용
	public void setList(List<Integer> list) {
		this.list = list;
	}
	
	public void makeLotto() {
		list = new ArrayList<>();
		List<Integer> range = IntStream.range(1, 45).boxed().collect(Collectors.toList());
		Collections.shuffle(range);
		for(int i=0; i < 6; i++) {
			list.add(range.get(i));
		}
		Collections.sort(list);
	}
	
	public void makeManualLotto(String manualLotto) {
		list = new ArrayList<>();
		for(String num : manualLotto.split(",")) {
			list.add(Integer.parseInt(num.trim()));
		}
		Collections.sort(list);
	}
	
	public void addCommonCount(int num) {
		commonCount += num;
	}
	
	//getList() 대신! 이게 객체지향적 사고
	public boolean hasNum(int num) {
		return list.contains(num);
	}
	
	public boolean isBonusCommon(int bonus) {
		return list.contains(bonus); 
	}
	//lotto.getCommonCount()를 하지 않기 위해 메소드를 Lottos에서 Lotto로 옮김 
	public Prize getPrize(int bonus) {
		return Prize.valueOf(getCommonCount(), isBonusCommon(bonus));
	}
	
	public int getPrice(int bonus) {
		return getPrize(bonus).getPrice();
	}
}