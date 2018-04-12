package lottoGame.domain;

import java.util.*;

public class LottoMachine {

    private static final int TIKETPAY = 1000;
    private static List<Integer> machineLottoNumbers = new ArrayList<>();

    static {
        for(int i = 1; i < 46; i++) {
            machineLottoNumbers.add(i);
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

    List<Integer> makeLottoNumbers() {

        shuffleLottoNumber();
        List<Integer> lottoNums = createLottoNumbers();
        sortLottoNumbers(lottoNums);

        return lottoNums;
    }

    private List<Integer> createLottoNumbers() {
        ArrayList<Integer> lottoNums = new ArrayList<>();

        for(int i = 0; i < 6; i++) {
            lottoNums.add(machineLottoNumbers.get(i));
        }
        return lottoNums;
    }

    private void sortLottoNumbers(List<Integer> lottoNums) {
        Collections.sort(lottoNums);
    }

    private void shuffleLottoNumber() {
        Collections.shuffle(machineLottoNumbers);
    }
}
