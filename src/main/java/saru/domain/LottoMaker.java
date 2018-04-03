package saru.domain;

import java.util.*;

// nums, lines = list
public class LottoMaker {
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String BLANK = "";
    private static final int MAX_LOTTO_NUM = 45;

    private List<LottoNum> baseNums = new ArrayList<>();

    private LottoMaker() {
        initBaseNums();
    }

    public static LottoMaker of() {
        return new LottoMaker();
    }

    public List<LottoNum> makeAutoLottoNums() {
        Collections.shuffle(baseNums);
        List<LottoNum> subList = baseNums.subList(0, 6);
        Collections.sort(subList,
                Comparator.comparingInt(LottoNum::getNum));

        return new ArrayList<>(subList);
    }

    public List<LottoLine> makeAutoLottoLines(int buyNum) {
        List<LottoLine> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < buyNum; i++) {
            lottoNumbers.add(LottoLine.of(makeAutoLottoNums()));
        }
        return lottoNumbers;
    }

    public List<LottoNum> makeManualLottoNums(String numStr) {
        String[] numArr = numStr.replaceAll(SPACE, BLANK).split(COMMA);

        List<LottoNum> lottoNums = new ArrayList<>();
        addArrToLottoNums(numArr, lottoNums);

        return lottoNums;
    }

    private void addArrToLottoNums(String[] winNumArr, List<LottoNum> lottoNums) {
        for (String str : winNumArr) {
            int toInputNum = Integer.parseInt(str);
            lottoNums.add(LottoNum.of(toInputNum));
        }
    }

    private void initBaseNums() {
        for (int i = 1; i <= MAX_LOTTO_NUM; i++) {
            baseNums.add(LottoNum.of(i));
        }
    }
}
