package lottoGame.domain;

import java.util.*;

public class LottoMachine {

    private static final int TIKETPAY = 1000;
    private static List<LottoNo> machineLottoNumbers = new ArrayList<>();

    static {
        for(int i = 1; i < 46; i++) {
            machineLottoNumbers.add(new LottoNo(i));
        }
    }

    public List<Lotto> getLottoTiket(int totalTiketPrice, int handOperatedLottoCount) {

        List<Lotto> lottoes = new ArrayList<>();

        for(int i = 0; i < caculateLottoTiketCount(totalTiketPrice, handOperatedLottoCount); i++) {
            lottoes.add(new Lotto(makeLottoNumbers()));
        }

        return lottoes;
    }

    int caculateLottoTiketCount(int totalTiketPrice, int handOperatedLottoCount) {

        int autoTotalTiketPrice = (totalTiketPrice / TIKETPAY) - (handOperatedLottoCount);

        if(autoTotalTiketPrice < 0) {
            throw new IllegalArgumentException("로또 금액은 수동으로 입력한 갯수보다 적어야 합니다.");
        }

        return autoTotalTiketPrice;
    }

    Set<LottoNo> makeLottoNumbers() {

        shuffleLottoNumber();
        Set<LottoNo> lottoNums = createLottoNumbers();

        return lottoNums;
    }

    private Set<LottoNo> createLottoNumbers() {
        Set<LottoNo> lottoNums = new HashSet<>();

        for(int i = 0; i < 6; i++) {
            lottoNums.add(machineLottoNumbers.get(i));
        }
        return lottoNums;
    }

    private void shuffleLottoNumber() {
        Collections.shuffle(machineLottoNumbers);
    }
}
