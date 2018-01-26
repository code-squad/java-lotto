package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


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
        List<Integer> lotto = subList(shuffle(getLottoNumber()));

        return convertLottoNumber(sort(lotto));
    }

    private static List<Integer> getLottoNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public static List<LottoNumber> convertLottoNumber(List<Integer> userNumbers) {
        return userNumbers.stream().map(userNumber -> new LottoNumber(userNumber)).collect(Collectors.toList());
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
        if(lotto.contains(userNumber)){
            return 1;
        }
        return 0;
    }

    private static List<Integer> subList(List<Integer> numbers) {
        return numbers.subList(0, 6);
    }

    private static List<Integer> sort(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    private static List<Integer> shuffle(List<Integer> numbers) {
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
