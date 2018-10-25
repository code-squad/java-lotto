package com.zingoworks.lotto.domain;

import com.zingoworks.lotto.exception.DuplicateLottoNumberException;
import com.zingoworks.lotto.exception.SizeOutOfBoundsException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

import static com.zingoworks.lotto.utils.LottoUtils.*;

public class Lotto {
    static final int MIN_RANGE = 1;
    static final int MAX_RANGE = 45;
    static final List<Integer> BASIC_NUMBERS = getBasicNumbers();
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

        if (lottoNumbers.size() != REGULAR_CHOICE) {
            throw new SizeOutOfBoundsException("6개의 숫자를 입력해주세요.");
        }
    }

    static Lotto generateAutomaticLotto() {
        return new Lotto();
    }

    static Lotto generateManualLotto(String inputLottoNumber) {
        return new Lotto(inputLottoNumber);
    }

    //테스트 아니면 getter 없어도 되는데 좀 더 큰 단위를 테스트해야하는건가?
    List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    boolean contains(int number) {
        return lottoNumbers.contains(number);
    }

    int getCountOfHit(Lotto winningLotto) {
        int count = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningLotto.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    private static List<Integer> getBasicNumbers() {
        List<Integer> basicNumbers = new ArrayList<>();
        IntStream.range(MIN_RANGE, MAX_RANGE + 1).forEach(basicNumbers::add);
        return basicNumbers;
    }

    private List<Integer> generateRandomLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        List<Integer> shuffledRandomNumbers = getShuffledNumbers(BASIC_NUMBERS);
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