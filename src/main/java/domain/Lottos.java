package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public void addLotto(List<Integer> numbers) {
        lottos.add(Lotto.of(numbers));
    }

    List<Lotto> initAutoLottos(int n) {
        return IntStream.range(0, n).mapToObj(i -> Lotto.of(LottoUtil.getRandNumbers())).collect(Collectors.toList());
    }

    public int getMatchLottos(List<Integer> answer, int matchNum) {
        return (int)lottos.stream().filter(factor -> factor.getNumOfMatches(answer) == matchNum).count();
    }

    public List<Integer> getResult(List<Integer> answer){
        return IntStream.range(3, 7).mapToObj(i -> getMatchLottos(answer, i)).collect(Collectors.toList());
    }

}
