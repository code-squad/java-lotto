package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class Lotto implements Checkable {
    public static final int MIN = 1;
    public static final int MAX = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String SPLITER = ",";

    private Set<Integer> lottoNumbers;

    private Lotto(Set<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.check();
    }

    @Override
    public void check(){
        if(!this.checkSize()) throw new IllegalArgumentException();
        if(!this.checkNumbers()) throw new IllegalArgumentException();
    }

    public int match(Lotto other){
        int count = 0;
        for (Integer lottoNumber : this.lottoNumbers) {
            if(other.isContain(lottoNumber)) count++;
        }
        return count;
    }

    // include duplication check.
    public boolean checkSize(){
        if(lottoNumbers.size() != LOTTO_NUMBERS_SIZE){
            return false;
        }
        return true;
    }

    public boolean isContain(int number){
        return this.lottoNumbers.contains(number);
    }

    @Override
    public boolean checkNumbers() {
        for (Integer lottoNumber : lottoNumbers) {
            if(lottoNumber < MIN || lottoNumber > MAX) return false;
        }
        return true;
    }

    public static Lotto ofText(String lottoText){
        String[] lottoTexts = lottoText.split(SPLITER);
        Set<Integer> lottoNumbers = new HashSet<>();
        for (String text : lottoTexts) {
            lottoNumbers.add(Integer.parseInt(text));
        }
        if(lottoTexts.length != lottoNumbers.size()) throw new IllegalArgumentException();
        return new Lotto(lottoNumbers);
    }



}
