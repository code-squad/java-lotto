package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    public static final int PRICE_OF_GAME = 1000;

    final int MIN_RANGE = 1;
    final int MAX_RANGE = 45;
    final int MAX_REGULAR_NUMBER = 6;

    private List<Integer> gameNumber;

    Game() {
        generateGameNumber(shuffleNumbers());
        sortGameNumber();
    }

    public List<Integer> getGameNumber() {
        return gameNumber;
    }

    int countWinning(List<Integer> lastWinningNumbers) {
        int count = 0;
        //인덴트 뎁스를 1로 줄이고자 하면 인자 3개인 메서드를 추출해야하는데 다른 방법은 없을까요?
        for (Integer integer : gameNumber) {
            if (lastWinningNumbers.contains(integer)) {
                count++;
            }
        }
        return count;
    }

    private void generateGameNumber(List<Integer> shuffledNumber) {
        this.gameNumber = new ArrayList<>();
        for (int i = 0; i < MAX_REGULAR_NUMBER; i++) {
            gameNumber.add(shuffledNumber.get(i));
        }
    }

    private List<Integer> shuffleNumbers() {
        List<Integer> numberSet = new ArrayList<>();
        for (int i = MIN_RANGE; i < MAX_RANGE; i++) {
            numberSet.add(i);
        }
        Collections.shuffle(numberSet);
        return numberSet;
    }

    private void sortGameNumber() {
        Collections.sort(this.gameNumber);
    }
}
