package saru.domain;

import java.util.*;

// nums, lines = list
public class LottoMaker {
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String BLANK = "";
    private static final int MAX_LOTTO_NUM = 45;
    public static final int MAX_ARR_NUM = 6;
    public static final int ARR_NUM = MAX_ARR_NUM;

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

        if (numArr.length != ARR_NUM) {
            throw new IllegalArgumentException("입력한 번호 수가 여섯개가 아님");
        }

        List<LottoNum> lottoNums = new ArrayList<>();

        try {
            addArrToLottoNums(numArr, lottoNums);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("입력값이 정상범위가 아님");
        }

        return lottoNums;
    }

    public LottoLine makeManualLottoLine(String numStr) {
        List<LottoNum> lottoNums = null;
        try {
            lottoNums = makeManualLottoNums(numStr);
        } catch (IllegalArgumentException e) {
            System.out.println("입력한 번호가 잘못 되었습니다.");
            throw new IllegalArgumentException(e);
        }

        return LottoLine.of(lottoNums);
    }

    private void addArrToLottoNums(String[] winNumArr, List<LottoNum> lottoNums) {
        for (String str : winNumArr) {
            int toInputNum = Integer.parseInt(str);

            try {
                lottoNums.add(LottoNum.of(toInputNum));
            } catch (IllegalArgumentException e) {
                System.out.println("인자가 정상범위가 아닙니다.");
                throw new IllegalArgumentException(e);
            }
        }
    }

    private void initBaseNums() {
        for (int i = 1; i <= MAX_LOTTO_NUM; i++) {
            baseNums.add(LottoNum.of(i));
        }
    }
}
