package calculator;

import org.apache.commons.lang3.StringUtils;

public class Positive {
    int number;


    public int getNumber() {
        return number;
    }

    public void addNumber(Positive positive) {
        this.number += positive.getNumber();
    }


    public Positive(int number){
        if(number < 0){
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public Positive(String number){

        if(number == null || number.isEmpty() || number.trim().isEmpty() ){
            throw new IllegalArgumentException();
        }

        if(!StringUtils.isNumeric(number)){
            throw new IllegalArgumentException();
        }

        int paramNumber = Integer.parseInt(number);
        if(paramNumber < 0){
            throw new IllegalArgumentException();
        }

        this.number = paramNumber;
    }

}
