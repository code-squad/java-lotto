package lottoGame.model;

import java.util.HashMap;
import java.util.Map;

public class LottoNumbers {
    static final int MINNUM = 1;
    static final int MAXNUM = 46;
    private final int lottoNum;
    private static final Map<Integer,LottoNumbers> numberMap = new HashMap();
    static {
        for(int i = MINNUM; i < MAXNUM; i++) {
            numberMap.put(i,new LottoNumbers(i));
        }
    }

    public LottoNumbers(int num) {
        this.lottoNum = num;
    }

    static LottoNumbers checkValidation(int num) {
        if(MINNUM > num || num > MAXNUM) {
            throw new IllegalArgumentException();
        }

        return numberMap.get(num);
    }

    public static LottoNumbers of(int value) {
        return checkValidation(value);
    }

    public static LottoNumbers of(String value) {
        if(value == null){
           throw new IllegalArgumentException("없는 값");
        }

        return checkValidation(Integer.valueOf(value));
    }

    public int getInteger() {
        return lottoNum;
    }
}
