package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final int COST = 1000;
    public static final int PICK_COUNT = 6;

    private Set<LottoNumber> numbers;

    public Lotto(List<Integer> numbers){
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        validate();
    }

    public Lotto(String text){
        if(text.isEmpty()){
            throw new IllegalArgumentException();
        }

        List<Integer> numbers = toInts(text.split(","));

        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        validate();
    }

    private void validate(){
        if(numbers.size() < 6){
            throw new IllegalArgumentException("번호 입력을 잘못하였습니다.");
        }
    }

    private static List<Integer> toInts(String[] values){
        return Arrays.stream(values)
                .map(v -> Integer.parseInt(v.trim()))
                .collect(Collectors.toList());
    }

    private static int toInt(String value){
        return Integer.parseInt(value.trim());
    }


    public int matchCount(Lotto lotto){
        int matchCount = 0;
        for(LottoNumber number : numbers){
            if(lotto.contains(number)){
                matchCount++;
            }
        }

        return matchCount;
    }

    public boolean contains(LottoNumber number){
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(numbers);
    }
}
