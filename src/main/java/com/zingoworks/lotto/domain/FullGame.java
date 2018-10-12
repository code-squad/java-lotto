package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static com.zingoworks.lotto.controller.LottoMain.PRICE_OF_GAME;

public class FullGame {
    private List<Game> fullGame = new ArrayList<>();

    public FullGame(int purchaseAmount) {
        generateFullGames(purchaseAmount);
    }

    public List<Game> getFullGame() {
        return fullGame;
    }

    private void generateFullGames(int purchaseAmount) {
        for (int i = 0; i < purchaseAmount / PRICE_OF_GAME; i++) {
            fullGame.add(new Game());
        }
    }
}
