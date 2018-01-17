package lotto.domain;

import lotto.type.WinningType;

import java.util.*;

public class Lotto {
    public static final int LOTTO_COST = 1000;
    public static final int LOTTO_PICK_COUNT = 6;
    public static List<Integer> TARGET_NUMBER;

    private static final int LOTTO_MAX_NUMBER = 45;

    private List<Integer> numbers;
    private WinningType winningType;

    static {
        // init lotto number range
        TARGET_NUMBER = new ArrayList<>();
        for(int i=0 ; i<LOTTO_MAX_NUMBER ; i++){
            TARGET_NUMBER.add((i+1));
        }
    }

    public Lotto(List<Integer> numbers){
        validateNumber(numbers);

        this.numbers = numbers;
    }

    private void validateNumber(List<Integer> numbers) {
        for(int number : numbers){
            if(!TARGET_NUMBER.contains(number)){
                throw new IllegalArgumentException("번호가 범위를 벗어났습니다.");
            }
        }
    }

    public WinningType matchLuckyNumbers(Lotto lucky){
        winningType = WinningType.parse(getMatchCount(lucky));

        return winningType;
    }

    public int getMatchCount(Lotto lucky){
        int matchCount = 0;
        for(int luckyNumber : lucky.numbers){
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
        return winningType == this.winningType;
    }

    @Override
    public String toString() {
        numbers.sort(Comparator.comparingInt(o -> o));

        return Arrays.toString(numbers.toArray());
    }
}
