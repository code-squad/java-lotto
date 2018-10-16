package com.zingoworks.lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
Test the program before you write it.
Clean code that works.

Lotto Class 테스트
1. 6개의 랜덤숫자 발생
1-1) 1~45까지의 basic number set 생성
1-2) 1~45까지의 숫자 중 6개만 추출하여 로또넘버 생성
1-3) 6개의 로또넘버를 오름차순 정렬
2. 6개의 숫자 중 적중개수 구하기
*/

public class LottoTest {
    @Test
    public void testLotto() throws Exception {
        Lotto lotto = new Lotto();
    }

    @Test
    public void testBasicNumbers() {
        Lotto lotto = new Lotto();
        assertEquals(lotto.getBasicNumbers().size(), 45);
        for (int i = 1; i <= 45; i++) {
            assert(lotto.getBasicNumbers().contains(i));
        }
    }

    @Test
    public void testLottoNumbers() {
        Lotto lotto = new Lotto();
        assertEquals(lotto.getLottoNumbers().size(), 6);
        assertEquals(new HashSet<>(lotto.getLottoNumbers()).size(), 6);
    }

    @Test
    public void testCollectionsSort() {
        Lotto lotto = new Lotto();
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println(list);
        lotto.getSortedNumbers(list);
        System.out.println(list);
    }

    @Test
    public void testCollectionSuffle() {
        Lotto lotto = new Lotto();
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println(list);
        lotto.getShuffledNumbers(list);
        System.out.println(list);
        lotto.getShuffledNumbers(list);
        System.out.println(list);
        lotto.getShuffledNumbers(list);
        System.out.println(list);
        lotto.getShuffledNumbers(list);
        System.out.println(list);
    }

    @Test
    public void testCountMatching() {
        List<Integer> winning = new ArrayList<>();
        winning.add(1);
        winning.add(2);
        winning.add(3);
        winning.add(4);
        winning.add(5);
        winning.add(6);

        Lotto lotto = new Lotto();
        System.out.println(lotto.countMatchingNumbers(winning));
        lotto = new Lotto();
        System.out.println(lotto.countMatchingNumbers(winning));
        lotto = new Lotto();
        System.out.println(lotto.countMatchingNumbers(winning));
        lotto = new Lotto();
        System.out.println(lotto.countMatchingNumbers(winning));
        lotto = new Lotto();
        System.out.println(lotto.countMatchingNumbers(winning));
        lotto = new Lotto();
        System.out.println(lotto.countMatchingNumbers(winning));
    }

    public static void main(String[] args) {
        Lotto testLotto = new Lotto();
    }

}