package lotto;

import dto.*;

import java.util.*;

public class UserLotto {
    private List<Lotto> userLottos = new ArrayList<>();

    public UserLotto(int count) {
        for (int i = 0; i < count; i++) {
            userLottos.add(new Lotto());
        }
    }

    public Map<Integer, Integer> matchNum(Lotto winningLotto) {
        Map<Integer, Integer> gameResult = new Reward().lottoRewardCount();
        for (Lotto userLotto : userLottos) {
            int reward = userLotto.gameStart(winningLotto);
            if (reward > 2)
                gameResult.put(reward, gameResult.get(reward) + 1);
        }
        return gameResult;
    }

    public UserLottoDto toDto() {
        List<LottoDto> userLottoDto = new ArrayList<>();
        for (Lotto lotto : userLottos) {
            userLottoDto.add(lotto.toDto());
        }
        return new UserLottoDto(userLottoDto);
    }
}















