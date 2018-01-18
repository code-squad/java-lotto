package model;

import java.util.Arrays;

public enum ResultTypes {

    NO_MATCH(0, 0),
    MATCH3(3, 5000),
    MATCH4(4, 50000),
    MATCH5(5, 1500000),
    MATCH6(6, 2000000000);

    ResultTypes(int matchCount, int price){
        this.matchCount = matchCount;
        this.price = price;
    }

    public static ResultTypes findByCode(int code) {
        return Arrays.stream(ResultTypes.values())
                .filter(result -> result.hasCode(code))
                .findAny()
                .orElse(NO_MATCH);
    }

    public boolean hasCode(int code){
        return this.matchCount == code;
    }

    public int matchCount;

    public int price;

}
