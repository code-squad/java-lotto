package domain;

import dto.LottoResult;
import spark.utils.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class LottoExecutor {

    public static List<LottoResult> execute(List<Lotto> lottos, WinningNumbers winningNumbers) {
        checkArguments(lottos, winningNumbers);
        return lottos.stream()
                     .map(lotto -> lotto.getLottoResult(winningNumbers))
                     .collect(Collectors.toList());
    }

    private static void checkArguments(List<Lotto> lottos, WinningNumbers winningNumbers) {
        if (CollectionUtils.isEmpty(lottos) || winningNumbers == null) {
            throw new IllegalArgumentException();
        }
    }

}
