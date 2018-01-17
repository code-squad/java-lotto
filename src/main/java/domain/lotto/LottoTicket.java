package domain.lotto;

import enums.WinningRules;

import java.util.*;

public class LottoTicket {

    public static final Integer PRICE = 1000;
    private static final Integer LOTTO_MAX_SIZE = 45;
    private static List<LottoNumber> lottoNumbers;
    private List<LottoNumber> numbers;

    static {
        lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= LOTTO_MAX_SIZE ; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    public LottoTicket() {
        this.numbers = new ArrayList<>();
        autoCreateNumber();
        this.sortingNumber();
    }

    private void sortingNumber(){
        Collections.sort(this.numbers);
    }

    private void autoCreateNumber() {
        for (int i = 0; i <100 ; i++) {
            Collections.shuffle(lottoNumbers);
        }
        for (int i = 0; i <6 ; i++) {
            this.numbers.add(new LottoNumber(lottoNumbers.get(i)));
        }
    }

    public void insertNumber(String text) {
        if (text.isEmpty()) {
            return;
        }

        List<String> numberString = Arrays.asList(text.replaceAll(" ", "").split(","));

        List<LottoNumber> newNumbers = new ArrayList<>();

        for (int i = 0; i < numberString.size(); i++) {
            newNumbers.add(new LottoNumber(Integer.parseInt(numberString.get(i))));
        }

        this.numbers = newNumbers;

        this.sortingNumber();
    }

    public WinningRules winningMaching(List<LottoNumber> winningNumbers) {
        Integer count = 0;

        for (LottoNumber winningNumber : winningNumbers) {
            for (LottoNumber thisNumber : this.numbers) {
                if (winningNumber.equals(thisNumber)) {
                    count++;
                }
            }
        }

        return WinningRules.findByMatchCount(count);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
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

        if (this.numbers.isEmpty() || this.numbers.isEmpty() || that.numbers.size() != this.numbers.size())
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
