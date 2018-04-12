package LottoGame;

        import java.util.List;

/**
 * Created by hongjong-wan on 2018. 4. 8..
 */
public class WinningLotto {

    private LottoNos winningLottoNos;
    private LottoNo bonusNumber;

    public WinningLotto(String text, LottoNo bonusNumber) {
        this.winningLottoNos = createWinningLotto(split(text));
        if (winningLottoNos.isDuplicate(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호 6개 값이아니어야 합니다.");
        }
        this.bonusNumber = bonusNumber;
    }

    public static String[] split(String text) {
        return text.split(",");
    }

    public static LottoNos createWinningLotto(String[] arr) {
        LottoNos winningLottoNos = new LottoNos();
        for (String str : arr) {
            winningLottoNos.add(new LottoNo(Integer.parseInt(trim(str))));
        }
        return winningLottoNos;
    }

    public static String trim(String str) {
        return str.trim();
    }

    public int getMatchCount(LottoNos lottoNos) {
        return lottoNos.getMatchCount(winningLottoNos);
    }

    public boolean matchBonus(LottoNos lottoNos) {
        return lottoNos.matchBonus(bonusNumber);
    }
}