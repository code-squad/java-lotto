package saru.domain;

// 유틸로 따로 뺄까 생각했지만 비교 기준이 되는 당첨 번호는 만들어 두는게 맞는 것 같다.
public class LottoMatcher {
    private WinningLotto winningLotto;

    private LottoMatcher(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public static LottoMatcher of(WinningLotto winningLotto) {
        return new LottoMatcher(winningLotto);
    }

    public int match(LottoLine lottoLine) {
        int matchNum = 0;

        // TODO 위닝 로또의 요소중 해당 로또 넘버와 일치하는게 있는지?
        for (LottoNum lottoNum : lottoLine.getNumbers()) {
            if (winningLotto.checkContain(lottoNum)) {
                matchNum++;
            }
        }

        return matchNum;
    }
}
