package lotto;

import dto.WinningLottoDto;
import util.Utility;
import vo.Num;

import java.util.*;

public class WinningLotto {
    private Set<Num> winningLotto = new TreeSet<>();

    public WinningLotto(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            winningLotto.add(new Num(Utility.fromStringToInteger(winningNumber)));
        }
        if (winningLotto.size() != 6)
            throw new IllegalArgumentException();
    }

    public Lotto makeWinningLotto() {
        return new Lotto(winningLotto);
    }

//    public void matchNum(UserLottoDto userLottoDto) {
//        Map<Integer, Integer> rank = new HashMap<>();
//        for (int i = 0; i < userLottoDto.getUserLottoDto().size(); i++) {
//            for (int j = 0; j < winningLotto.size(); j++) {
//                userLottoDto.getUserLottoDto().get(j);
//            }
//        }
//    }

}
