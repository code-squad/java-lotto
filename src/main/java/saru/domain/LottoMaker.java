package saru.domain;

import java.util.*;

public class LottoMaker {
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String BLANK = "";
    private static final int MAX_LOTTO_NUM = 45;

    private List<LottoNum> baseNumberList = new ArrayList<>();

    private LottoMaker() {
        initBaseNumberList();
    }

    public static LottoMaker of() {
        return new LottoMaker();
    }

    public List<LottoNum> makeLottoList() {
        Collections.shuffle(baseNumberList);
        List<LottoNum> subList = baseNumberList.subList(0, 6);
        Collections.sort(subList,
                Comparator.comparingInt(LottoNum::getNumber));

        return new ArrayList<>(subList);
    }

    public List<LottoLine> makeLottoNumber(int buyNum) {
        List<LottoLine> lottoNumberLists = new ArrayList<>();

        for (int i = 0; i < buyNum; i++) {
            lottoNumberLists.add(LottoLine.of(makeLottoList()));
        }
        return lottoNumberLists;
    }

    public List<LottoNum> makeManualLottoLine(String numStr) {
        String[] winNumArr = numStr.replaceAll(SPACE, BLANK).split(COMMA);

        List<LottoNum> lottoLine = new ArrayList<>();
        addLottoNum(winNumArr, lottoLine);

        return lottoLine;
    }

    private void addLottoNum(String[] winNumArr, List<LottoNum> lottoLine) {
        for (String str : winNumArr) {
            int toInputNum = Integer.parseInt(str);
            lottoLine.add(LottoNum.of(toInputNum));
        }
    }

    private void initBaseNumberList() {
        for (int i = 1; i <= MAX_LOTTO_NUM; i++) {
            baseNumberList.add(LottoNum.of(i));
        }
    }
}
