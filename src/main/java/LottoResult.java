import java.util.HashMap;

public class LottoResult {
    private int benefit;
    private HashMap<Integer, Integer> result;

    public LottoResult(HashMap<Integer, Integer> result, int benefit) {
        this.result = result;
        this.benefit = benefit;
    }

    public HashMap<Integer, Integer> getResult() {
        return result;
    }
    public int getBenefit(){
        return benefit;
    }

}
