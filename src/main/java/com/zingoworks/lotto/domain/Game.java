package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    public static final int PRICE_OF_GAME = 1000;

    final int MIN_RANGE = 1;
    final int MAX_RANGE = 45;
    final int MAX_REGULAR_NUMBER = 6;

    private List<Integer> gameNumbers;

    //1~45의 셔플 된 숫자세트에서 6개를 추출한 뒤 오름차순 정렬
    Game() {
        generateGameNumbers();
        sortGameNumbers();
    }

    public List<Integer> getGameNumbers() {
        return gameNumbers;
    }

    int countWinning(List<Integer> lastWinningNumbers) {
        int count = 0;
        //인덴트 뎁스를 1로 줄이고자 하면 인자 3개인 메서드를 추출해야하는데 다른 방법은 없을까요?
        for (Integer integer : gameNumbers) {
            if (lastWinningNumbers.contains(integer)) {
                count++;
            }
        }
        return count;
    }

    private void generateGameNumbers() {
        this.gameNumbers = new ArrayList<>();
        for (int i = 0; i < MAX_REGULAR_NUMBER; i++) {
            gameNumbers.add(shuffledBasicNumbers().get(i));
        }
    }

    private List<Integer> shuffledBasicNumbers() {
        List<Integer> numberSet = new ArrayList<>();
        for (int i = MIN_RANGE; i < MAX_RANGE; i++) {
            numberSet.add(i);
        }
        Collections.shuffle(numberSet);
        return numberSet;
    }

    private void sortGameNumbers() {
        Collections.sort(this.gameNumbers);
    }
}
