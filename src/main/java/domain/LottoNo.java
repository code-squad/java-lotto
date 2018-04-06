package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNo {
    private static final int MAX_SIZE = 6;
    private int lottoNo;

    public LottoNo(int number) {
        if (!isValid(number)) {
            throw new IllegalArgumentException("로또 번호는 1~45까지 입니다.");
        }
        this.lottoNo = number;
    }

    public LottoNo(String number) {
        this(Integer.parseInt(number));
    }

    // manual : 1줄(6개) 로또 번호 생성
    public static List<LottoNo> getLottoNos(List<Integer> numbers) {
        List<LottoNo> lottoNos = new ArrayList<>();
        for (Integer number : numbers) {
            LottoNo lottoNo = new LottoNo(number);
            lottoNos.add(lottoNo);
        }
        return lottoNos;
    }

    public static List<LottoNo> getLottoNosFromString(String numberLine) {
        List<Integer> lottoNumbers = new ArrayList<>();
        String[] splitNos = numberLine.replaceAll(" ", "").trim().split(",");
        for (String number : splitNos) {
            int lottoNo = Integer.parseInt(number);
            if (!isValid(lottoNo)) {
                throw new IllegalArgumentException("0부터 46까지 숫자만 입력 가능합니다.");
            }
            lottoNumbers.add(lottoNo);
        }
        return getLottoNos(lottoNumbers);
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
        // System.out.println(numbers);
        return numbers;
    }

    public boolean hasNumber(int number) {
        return this.lottoNo == number;
    }

    public static boolean isValid(int number) {
        return number > 0 && number < 46;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return this.lottoNo == lottoNo.lottoNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNo);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNo);
    }
}
