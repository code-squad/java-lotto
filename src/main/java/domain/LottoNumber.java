package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if(lottoNumber >= 46 || lottoNumber <= 0){
            throw new IllegalArgumentException();
        }
        this.lottoNumber = lottoNumber;
    }

    public static List<LottoNumber> getLotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            numbers.add(i);
        }

        List<Integer> lotto = subList(shuffle(numbers));

        return convertLottoNumber(sort(lotto));
    }

    public static List<LottoNumber> convertLottoNumber(List<Integer> userNumbers) {
        List<LottoNumber> lottoNumber = new ArrayList<LottoNumber>();
        for(int userNumber : userNumbers){
            lottoNumber.add(new LottoNumber(userNumber));
        }
        return lottoNumber;
    }


    private static List<Integer> subList(List<Integer> numbers) {
        return numbers.subList(0, 6);
    }

    private static List<Integer> sort(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    private static List<Integer>shuffle(List<Integer> numbers) {
        Collections.shuffle(numbers);
        return numbers;
    }

    public boolean contains(List<LottoNumber> lotto) {
        for(LottoNumber lottoNumber : lotto){
            if(lottoNumber.isMatch(this.lottoNumber)){
                return true;
            }
        }
        return false;
    }

    private boolean isMatch(int lottoNumber) {
        if(this.lottoNumber == lottoNumber){
            return true;
        }
        return false;
    }
}
