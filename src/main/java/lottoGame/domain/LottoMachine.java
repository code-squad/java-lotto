package lottoGame.domain;

import java.util.*;

public class LottoMachine {

    private static final int TIKETPAY = 1000;
    private static ArrayList<Integer> machineLottoNumbers = new ArrayList<>();

    static {
        for(int i = 1; i < 46; i++) {
            machineLottoNumbers.add(i);
        }
    }

    public Lotto[] giveLottoTiket(int totalTiketPrice) {

        Lotto[] lottoes = new Lotto[caculateLottoTiketCnt(totalTiketPrice)];

        for(int i = 0; i < lottoes.length; i++) {
            lottoes[i] = new Lotto(makeLottoNumbers());
        }

        return lottoes;
    }

    int caculateLottoTiketCnt(int totalTiketPrice) {

        return totalTiketPrice / TIKETPAY;
    }

    ArrayList<Integer> makeLottoNumbers() {

        shuffleLottoNumber();
        ArrayList<Integer> lottoNums = createLottoNumbers();
        sortLottoNumbers(lottoNums);

        return lottoNums;
    }

    private ArrayList<Integer> createLottoNumbers() {
        ArrayList<Integer> lottoNums = new ArrayList<>();

        for(int i = 0; i < 6; i++) {
            lottoNums.add(machineLottoNumbers.get(i));
        }
        return lottoNums;
    }

    private void sortLottoNumbers(ArrayList<Integer> lottoNums) {
        Collections.sort(lottoNums);
    }

    private void shuffleLottoNumber() {
        Collections.shuffle(machineLottoNumbers);
    }
}
