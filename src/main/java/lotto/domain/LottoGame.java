package lotto.domain;

import lotto.dto.InputDto;
import lotto.dto.LottoDto;
import lotto.dto.ResultDto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottos = new ArrayList<>();
    private int numberOfLottoToBuyRandom;
    private Money money;

    public LottoGame(InputDto inputDto) {
        money = inputDto.getMoney();
        numberOfLottoToBuyRandom = money.getAvailableForPurchaseLotto() - inputDto.getNumberOfLottoToBuyManually();

        String[] numbers = inputDto.getEnterNumbers();

        for (int i = 0; i < inputDto.getNumberOfLottoToBuyManually(); i++) {
            lottos.add(Lotto.enterNumberOfLotto(numbers[i]));
        }

        for (int i = 0; i < numberOfLottoToBuyRandom; i++) {
            lottos.add(Lotto.generateLottoNumber());
        }
    }

    private GameResult compare(String input, int bonusNumber){
        WinningNumbers winningNumbers = new WinningNumbers(input, bonusNumber);
        GameResult result = new GameResult();

        for (Lotto lotto : lottos) {
            int count = winningNumbers.compare(lotto);
            boolean matchBonus = lotto.isContainBonusNumber(bonusNumber);

            result.countMatchLotto(count, matchBonus);
        }
        return result;
    }

    public ResultDto matchLotto(String input, int bonusNumber) {
        GameResult result = compare(input, bonusNumber);
        return result.createResultDto(money);
    }

    public LottoDto createDto() {
        return new LottoDto(lottos, numberOfLottoToBuyRandom);
    }
}
