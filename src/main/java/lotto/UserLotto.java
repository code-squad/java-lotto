package lotto;

import dto.*;
import vo.Num;

import java.util.*;

public class UserLotto {
    private List<Lotto> userLottos = new ArrayList<>();

    public UserLotto(int count) {
        for (int i = 0; i < count; i++) {
            userLottos.add(new Lotto());
        }
    }

    public Map<Rank, Integer> matchNum(Lotto winningLotto, Num bonusNum) {
        Map<Rank, Integer> gameResult = new Reward().getInitReward();
        for (Lotto userLotto : userLottos) {
            int reward = userLotto.gameStart(winningLotto);
            boolean matchBonus = userLotto.isMatchBonusNum(bonusNum);
            if (reward > 2) {
                Rank grade = Rank.valueOf(reward, matchBonus);
                int matchCount = gameResult.get(grade);
                gameResult.put(grade, matchCount + 1);
            }
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















