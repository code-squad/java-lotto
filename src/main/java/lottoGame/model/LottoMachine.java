package lottoGame.model;

import java.util.*;

public class LottoMachine {

    private static final List<LottoNumbers> LOTTOVALUES = new ArrayList<LottoNumbers>();
    static {
        for(int i = LottoNumbers.MINNUM; i < LottoNumbers.MAXNUM; i++) {
            LOTTOVALUES.add(LottoNumbers.of(i));
        }
    }

    public static List<Lotto> createLottoGame(int cnt) {
        List<Lotto> lottoGames = new ArrayList<>();
        for(int i = 0; i < cnt; i++) {
            lottoGames.add(new Lotto(createNewLottoNums(LottoMachine.LOTTOVALUES)));
        }

        return lottoGames;
    }

    public static Set<LottoNumbers> createNewLottoNums(List<LottoNumbers> LOTTOVAS) {
        Collections.shuffle(LOTTOVAS);

        return getLottoNumbers(LOTTOVAS);
    }

    public static Set<LottoNumbers> getLottoNumbers(List<LottoNumbers> LOTTOVALUES) {
        Set<LottoNumbers> lottoNumbers = new HashSet<>();
        for(int i = 0; i < Lotto.LOTTOSIZE; i++) {
            lottoNumbers.add(LOTTOVALUES.get(i));
        }

        return lottoNumbers;
    }

}
