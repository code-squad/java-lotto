package com.zingoworks.lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

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

//    @Test
//    public void testBasicNumbers() {
//        Lotto lottery = new Lotto();
//        assertEquals(lottery.generateBasicNumbers().size(), 45);
//        for (int i = 1; i <= 45; i++) {
//            assert(lottery.generateBasicNumbers().contains(i));
//        }
//    }

    @Test
    public void testLottoNumbers() {
        Lotto lotto = new Lotto();
        assertEquals(lotto.generateRandomLottoNumbers().size(), 6);
        assertEquals(new HashSet<>(lotto.generateRandomLottoNumbers()).size(), 6);
    }

//    @Test
//    public void testCollectionsSort() {
//        Lotto lottery = new Lotto();
//        List<Integer> list = new ArrayList<>();
//        list.add(3);
//        list.add(2);
//        list.add(1);
//        System.out.println(list);
//        lottery.getSortedNumbers(list);
//        System.out.println(list);
//    }
//
//    @Test
//    public void testCollectionShuffle() {
//        Lotto lottery = new Lotto();
//        List<Integer> list = new ArrayList<>();
//        list.add(3);
//        list.add(2);
//        list.add(1);
//        System.out.println(list);
//        lottery.getShuffledNumbers(list);
//        System.out.println(list);
//        lottery.getShuffledNumbers(list);
//        System.out.println(list);
//        lottery.getShuffledNumbers(list);
//        System.out.println(list);
//        lottery.getShuffledNumbers(list);
//        System.out.println(list);
//    }

    @Test
    public void testCountMatching() {
        WinningLotto wn = new WinningLotto("1,2,3,4,5,6", 7);

        Lotto lottery = new Lotto();
        System.out.println(lottery.toString());
        System.out.println(lottery.getScore(wn).getCountOfHit());
    }

    public static void main(String[] args) {
        Lotto testLotto = new Lotto();
    }


}