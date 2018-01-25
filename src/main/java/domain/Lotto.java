package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Lotto {
    private List<LottoNumber> lotto;

    public Lotto(){
        this.lotto = getLotto();
    }

    public Lotto(List<Integer> lotto){

        this.lotto = convertLottoNumber(lotto);
    }

    // Factory Method : 자신의 객체를 생성하는 메소드
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

    public int countMatchLotto(WinningLotto winningLotto) {
        int count = 0;
        for(LottoNumber userNumber : this.lotto){
            count += winningLotto.matchYn(userNumber);
        }
        return count;
    }

    // 객체 지향적인 설계를 하다 보면 아래의 hasBonus와 같이 다른 객체에게 행위를 위임하는 동작만을 하는 메소드들이 많이 나오게 된다.
    public boolean hasBonus(WinningLotto winningLotto) {
        return winningLotto.hasBonus(lotto);
    }

    public int matchYn(LottoNumber userNumber) {
        if(contains(userNumber)){
            return 1;
        }
        return 0;
    }

    public boolean contains(LottoNumber userNumber){
        for(LottoNumber lottoNumbers : this.lotto){
            if(lottoNumbers.equals(userNumber)){
                return true;
            }
        }
        return false;
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

    @Override
    public String toString() {
        return String.join(", ", this.lotto.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lotto);
    }
}
