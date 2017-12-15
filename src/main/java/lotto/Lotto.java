package lotto;
import java.util.ArrayList;

public class Lotto {
	ArrayList<Integer> lotto = new ArrayList<>();
	
	public Lotto(ArrayList<Integer> lotto) {
		this.lotto = lotto;
	}

	protected ArrayList<Integer> getLotto(){
		return this.lotto;
	}
	

}
