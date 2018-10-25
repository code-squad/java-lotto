package com.zingoworks.lotto.domain;

import com.zingoworks.lotto.exception.DuplicateLottoNumberException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

import static com.zingoworks.lotto.utils.LottoUtils.*;

public class Lotto {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int REGULAR_CHOICE = 6;

    private List<Integer> lottoNumbers;

    private Lotto() {
        this.lottoNumbers = generateRandomLottoNumbers();
    }

    private Lotto(String inputLottoNumber) {
        this.lottoNumbers = LottoNumberParser.parse(inputLottoNumber);

        if (new HashSet(lottoNumbers).size() != LottoNumberParser.parse(inputLottoNumber).size()) {
            throw new DuplicateLottoNumberException("중복 된 숫자가 존재합니다.");
        }
    }

    static Lotto generateAutomaticLotto() {
        return new Lotto();
    }

    static Lotto generateManualLotto(String inputLottoNumber) {
        return new Lotto(inputLottoNumber);
    }

    List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    boolean contains(int number) {
        return this.lottoNumbers.contains(number);
    }

    Prize getPrize(WinningLotto winningLotto) {
        for (Prize prize : Prize.values()) {
            if(prize.getCountOfHit() == getCountOfHit(winningLotto.getWinningLotto())
                    && prize.isBonusHit() == winningLotto.isBonusHit(this)) {
                return prize;
            }
        }
        return null;
    }

    int getCountOfHit(Lotto winningLotto) {
        int count = 0;
        for (Integer winningNumber : winningLotto.getLottoNumbers()) {
            count = increaseCount(count, winningNumber);
        }
        return count;
    }

    private int increaseCount(int count, Integer winningNumber) {
        if (this.lottoNumbers.contains(winningNumber)) {
            count++;
        }
        return count;
    }

    List<Integer> getBasicNumberSet() {
        List<Integer> basicNumbers = new ArrayList<>();
        IntStream.range(MIN_RANGE, MAX_RANGE + 1).forEach(basicNumbers::add);
        return basicNumbers;
    }

    private List<Integer> generateRandomLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        List<Integer> shuffledRandomNumbers = getShuffledNumbers(getBasicNumberSet());
        for (int i = 0; i < REGULAR_CHOICE; i++) {
            lottoNumbers.add(shuffledRandomNumbers.get(i));
        }
        return lottoNumbers;
    }



    @Override
    public String toString() {
        return getSortedNumbers(lottoNumbers).toString();
    }
}