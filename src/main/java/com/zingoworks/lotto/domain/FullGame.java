package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static com.zingoworks.lotto.controller.LottoMain.PRICE_OF_GAME;

public class FullGame {
    private List<Game> fullGame;

    public FullGame(int purchaseAmount) {
        generateFullGames(purchaseAmount);
    }

    public List<Game> getFullGame() {
        return this.fullGame;
    }

    private void generateFullGames(int purchaseAmount) {
        this.fullGame = new ArrayList<>();
        for (int i = 0; i < purchaseAmount / PRICE_OF_GAME; i++) {
            this.fullGame.add(new Game());
        }
    }
}
