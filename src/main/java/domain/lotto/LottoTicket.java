package domain.lotto;

import enums.WinningRules;

import java.util.*;

public class LottoTicket {

    public static final Integer PRICE = 1000;
    private static final Integer LOTTO_MIN_NUMBER = 1;
    private static final Integer LOTTO_MAX_NUMBER = 45;
    private static final Integer LOTTO_NUMBER_SIZE = 6;
    private static final Integer LOTTO_SHUFFLE_TIMES = 100;
    private static final List<LottoNumber> lottoNumbers;

    private List<LottoNumber> numbers;

    static {
        lottoNumbers = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    public LottoTicket() {
        this.numbersShuffle();
        this.numbers = this.autoCreateNumber();
        this.sortingNumber();
    }

    private void sortingNumber() {
        Collections.sort(this.numbers);
    }

    private List<LottoNumber> autoCreateNumber() {

        List<LottoNumber> numbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_NUMBER_SIZE; i++) {
            numbers.add(new LottoNumber(lottoNumbers.get(i)));
        }
        return numbers;
    }

    private void numbersShuffle() {
        for (int i = 0; i < LOTTO_SHUFFLE_TIMES; i++) {
            Collections.shuffle(lottoNumbers);
        }
    }

    public void insertNumber(String text) {
        if (text.isEmpty()) {
            return;
        }

        List<LottoNumber> newNumbers = new ArrayList<>();
        List<String> numberString = parsingTextNumber(text);

        for (int i = 0; i < numberString.size(); i++) {
            newNumbers.add(new LottoNumber(numberString.get(i)));
        }

        this.numbers = newNumbers;

        this.sortingNumber();
    }

    private List<String> parsingTextNumber(String text) {
        return Arrays.asList(text.replaceAll(" ", "").split(","));
    }

    public WinningRules winningMaching(List<LottoNumber> winningNumbers) {
        Integer count = 0;

        for (LottoNumber winningNumber : winningNumbers) {
            count += isHitNumber(winningNumber);
        }

        return WinningRules.findByMatchCount(count);
    }

    private Integer isHitNumber(LottoNumber winningNumber) {
        for (LottoNumber thisNumber : this.numbers) {
            if (winningNumber.equals(thisNumber)) {
                return 1;
            }
        }
        return 0;
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers;
    }

    private boolean isEquals(int i, List<LottoNumber> that) {
        if (this.numbers.get(i).equals(that.get(i)))
            return true;

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoTicket that = (LottoTicket) o;

        if (this.numbers.isEmpty() || that.numbers.isEmpty() || that.numbers.size() != this.numbers.size())
            return false;

        for (int i = 0; i < that.numbers.size(); i++) {
            if (!isEquals(i, that.numbers)) return false;
        }

        return true;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(" " + this.numbers.get(i) + " ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }
}
