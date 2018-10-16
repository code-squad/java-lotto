package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResults {
    public static final int PRIZE_FIRST = 2000000000;
    public static final int SCORE_FIRST = 6;
    public static final int PRIZE_SECOND = 1500000;
    public static final int SCORE_SECOND = 5;
    public static final int PRIZE_THIRD = 50000;
    public static final int SCORE_THIRD = 4;
    public static final int PRIZE_FORTH = 5000;
    public static final int SCORE_FORTH = 3;

    private static final String COMMA = ",";

    private List<Integer> lastWinningNumbers;
    private Map<String, Integer> ranks;

    public LottoResults(FullLotto fullLotto, String lastWinningNumbers) {
        generateLastWinningNumbers(lastWinningNumbers);
        this.ranks = getRankMap(fullLotto.countFullWinning(this.lastWinningNumbers));
    }

    public Map<String, Integer> getRanks() {
        return ranks;
    }

    public int getEarningRate(int purchaseAmount) {
        return (earning() - purchaseAmount) / purchaseAmount * 100;
    }

    private int earning() {
        int earn = 0;
        earn += this.ranks.get("FORTH") * PRIZE_FORTH;
        earn += this.ranks.get("THIRD") * PRIZE_THIRD;
        earn += this.ranks.get("SECOND") * PRIZE_SECOND;
        earn += this.ranks.get("FIRST") * PRIZE_FIRST;
        return earn;
    }

    private void generateLastWinningNumbers(String str) {
        lastWinningNumbers = new ArrayList<>();
        String[] separatedStr = str.split(COMMA);
        for (String s : separatedStr) {
            lastWinningNumbers.add(Integer.parseInt(s));
        }
    }

    private Map<String, Integer> getRankMap(List<Integer> wins) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        //지금까지 스텝 진행했던 것을 기반으로도 간결화가 가능한가요?
        for (Integer integer : wins) {
            if (integer == 3) {
                a++;
            }
            if (integer == 4) {
                b++;
            }
            if (integer == 5) {
                c++;
            }
            if (integer == 6) {
                d++;
            }
        }

        Map<String, Integer> rankMapper = new HashMap<>();
        rankMapper.put("FORTH", a);
        rankMapper.put("THIRD", b);
        rankMapper.put("SECOND", c);
        rankMapper.put("FIRST", d);

        return rankMapper;
    }
}
