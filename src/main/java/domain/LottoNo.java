package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNo {
    private static final int MAX_SIZE = 6;
    private int number;

    public LottoNo(int number) {
        if (!isValid(number)) {
            throw new IllegalArgumentException("로또 번호는 1~45까지 입니다.");
        }
        this.number = number;
    }

    public LottoNo(String number) {
        this(Integer.parseInt(number));
    }

    // manual
    public static List<LottoNo> getLottoNos(List<Integer> numbers) {
        List<LottoNo> lottoNos = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNos.add(new LottoNo(number));
        }
        return lottoNos;
    }

    // auto
    public static List<LottoNo> getLottoNos() {
        return LottoNo.getLottoNos(makeRandomNumbers());
    }

    public static List<Integer> makeRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> numberPool = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            numberPool.add(i);
        }
        Collections.shuffle(numberPool);
        for (Integer number : numberPool) {
            if (numbers.size() >= MAX_SIZE) {
                break;
            }
            numbers.add(number);
        }
        numbers.sort(Integer::compareTo);
        System.out.println(numbers);
        return numbers;
    }

    public boolean hasNumber(int number) {
        return this.number == number;
    }

    public boolean isValid(int number) {
        return number > 0 && number < 46;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
