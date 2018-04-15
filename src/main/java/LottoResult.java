import java.util.Map;

public class LottoResult {
    private int benefit;
    private Map<Integer, Integer> result;

    public LottoResult(Map<Integer, Integer> result, int benefit) {
        this.result = result;
        this.benefit = benefit;
    }

    public Map<Integer, Integer> getResult() {
        return result;
    }
    public int getBenefit(){
        return benefit;
    }

}
