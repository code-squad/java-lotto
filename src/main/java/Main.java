import model.Lotto;
import model.LottoGame;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(14000);
        lottoGame.setWinningLotto(new Lotto(46, 6, Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoGame.runGames();

    }
}
