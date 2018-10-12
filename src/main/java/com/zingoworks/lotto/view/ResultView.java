package com.zingoworks.lotto.view;

import com.zingoworks.lotto.domain.FullGame;

import static com.zingoworks.lotto.controller.LottoMain.PRICE_OF_GAME;

public class ResultView {

    public static void printGames(int purchaseAmount, FullGame fullGame) {
        System.out.println(purchaseAmount / PRICE_OF_GAME + "게임을 구매했습니다.");
        for (int i = 0; i < fullGame.getFullGame().size(); i++) {
            System.out.println(fullGame.getFullGame().get(i).getGameNumber());
        }
    }
}
