package com.zingoworks.lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FullLottoTest {

    @Test
    public void 테스트_구입한모든로또의적중수() {
        List<Integer> lastWinningNumbers = new ArrayList<>();
        lastWinningNumbers.add(1);
        lastWinningNumbers.add(2);
        lastWinningNumbers.add(3);
        lastWinningNumbers.add(4);
        lastWinningNumbers.add(5);
        lastWinningNumbers.add(6);

        FullLotto fl = new FullLotto(10000);
        System.out.println(fl.countFullWinning(lastWinningNumbers));
    }

    @Test
    public void 테스트_구입한모든로또개수() {
        FullLotto fl = new FullLotto(10000);
        assertEquals(fl.getFullLotto().size(), 10);

        FullLotto fl2 = new FullLotto(5000);
        assertEquals(fl2.getFullLotto().size(), 5);
    }
}