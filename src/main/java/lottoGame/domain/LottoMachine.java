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

    public List<Lotto> giveLottoTiket(int totalTiketPrice) {

        List<Lotto> lottoes = new ArrayList<>();

        for(int i = 0; i < caculateLottoTiketCnt(totalTiketPrice); i++) {
            lottoes.add(new Lotto(makeLottoNumbers()));
        }

        return lottoes;
    }

    int caculateLottoTiketCnt(int totalTiketPrice) {

        return totalTiketPrice / TIKETPAY;
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
