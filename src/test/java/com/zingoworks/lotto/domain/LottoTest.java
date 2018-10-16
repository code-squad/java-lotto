package com.zingoworks.lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class LottoTest {

    @Test
    public void 테스트_로또일치개수확인() {
        List<Integer> lastWinningNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lastWinningNumbers.add(i);
        }

        Lotto lt = new Lotto();
        assertEquals(lt.countWinning(lastWinningNumbers), 6);
    }

    @Test
    public void 테스트_로또생성() {
        for (int i = 0; i < 10; i++) {
            Lotto lt = new Lotto();
            assertEquals(new HashSet<>(lt.generateLottoNumbers()).size(), 6);
        }
    }

    @Test
    public void 테스트_기본숫자세트생성() {
        Lotto lt = new Lotto();
        List<Integer> shuffledNumberSet = lt.getShuffledBasicNumbers();

        Set<Integer> verifyOverlappedNumbers = new HashSet<>();
        for (Integer integer : shuffledNumberSet) {
            verifyOverlappedNumbers.add(integer);
        }

        assertEquals(verifyOverlappedNumbers.size(), 45);
    }

    @Test
    public void 테스트_오름차순정렬() {
        Lotto lt = new Lotto();
        List<Integer> verifySotring = new ArrayList<>();
        verifySotring.add(6);
        verifySotring.add(5);
        verifySotring.add(4);
        verifySotring.add(3);
        verifySotring.add(2);
        verifySotring.add(1);

        System.out.println(verifySotring);
        System.out.println(lt.sortNumbers(verifySotring));
    }
}