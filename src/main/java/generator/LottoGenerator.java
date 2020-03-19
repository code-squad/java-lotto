package generator;

import domain.Lotto;
import vo.LottoNumber;
import domain.WinningLotto;

import java.util.List;
import java.util.stream.Collectors;

import static util.StringUtil.convertToInt;
import static util.StringUtil.split;

public interface LottoGenerator {
    List<Lotto> generateLotto();

    default List<LottoNumber> convertToLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    default WinningLotto generateWinningLotto(final String numbers, int bonusBall) {
        return new WinningLotto(
                new Lotto(convertToLottoNumber(convertToInt(split(numbers)))),
                new LottoNumber(bonusBall)
        );
    }
}
