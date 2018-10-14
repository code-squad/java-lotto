package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final int MIN_RANGE = 1;
    private final int MAX_RANGE = 45;
    private final int MAX_REGULAR_NUMBER = 6;
    private List<Integer> gameNumber;

    public Game() {
        generateGameNumber(shuffledNumberSet());
        sortGameNumber();
    }

    public List<Integer> getGameNumber() {
        return gameNumber;
    }

    private void generateGameNumber(List<Integer> shuffledNumber) {
        this.gameNumber = new ArrayList<>();
        for (int i = 0; i < MAX_REGULAR_NUMBER; i++) {
            gameNumber.add(shuffledNumber.get(i));
        }
    }

    private List<Integer> shuffledNumberSet() {
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
