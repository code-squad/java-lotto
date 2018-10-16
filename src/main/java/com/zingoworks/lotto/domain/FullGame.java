package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static com.zingoworks.lotto.domain.Game.PRICE_OF_GAME;

public class FullGame {
    private List<Game> fullGame;

    public FullGame(int purchaseAmount) {
        generateFullGames(purchaseAmount);
    }

    public List<Game> getFullGame() {
        return this.fullGame;
    }

    List<Integer> countFullWinning(List<Integer> lastWinningNumbers) {
        List<Integer> results = new ArrayList<>();
        for (Game game : fullGame) {
            results.add(game.countWinning(lastWinningNumbers));
        }
        return results;
    }

    private void generateFullGames(int purchaseAmount) {
        this.fullGame = new ArrayList<>();
        for (int i = 0; i < purchaseAmount / PRICE_OF_GAME; i++) {
            this.fullGame.add(new Game());
        }
    }
}
