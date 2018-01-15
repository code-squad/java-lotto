package lotto.domain;

import lotto.type.WinningType;

import java.util.*;

public class Lotto {
    public static final int LOTTO_COST = 1000;
    public static final int LOTTO_PICK_COUNT = 6;

    private static final int LOTTO_MAX_NUMBER = 45;
    private static List<Integer> TARGET_NUMBER;

    private List<Integer> numbers;
    private WinningType winningType;

    static {
        // init lotto number range
        TARGET_NUMBER = new ArrayList<>();
        for(int i=0 ; i<LOTTO_MAX_NUMBER ; i++){
            TARGET_NUMBER.add((i+1));
        }
    }

    public Lotto(){
        this.numbers = new ArrayList<>(LOTTO_PICK_COUNT);

        Collections.shuffle(TARGET_NUMBER);
        for(int i=0 ; i<LOTTO_PICK_COUNT ; i++){
            this.numbers.add(TARGET_NUMBER.get(i));
        }
    }

    public WinningType matchLuckyNumbers(int[] luckyNumbers){
        winningType = WinningType.parse(getMatchCount(luckyNumbers));

        return winningType;
    }

    public int getMatchCount(int[] luckyNumbers){
        int matchCount = 0;
        for(int luckyNumber : luckyNumbers){
            if(numbers.contains(luckyNumber)){
                matchCount++;
            }
        }

        return matchCount;
    }

    public int getWinningPrizes(){
        return winningType.getPrizes();
    }

    public boolean isWinningType(WinningType winningType){
        return winningType.equals(this.winningType);
    }

    @Override
    public String toString() {
        numbers.sort(Comparator.comparingInt(o -> o));

        return Arrays.toString(numbers.toArray());
    }
}
