package model;

import java.util.Arrays;

public enum ResultTypes {

    NOMATCH(-1) {
        int getPrice() {return -1;};
    },
    MATCH3(3) {
        int getPrice() {return 5000;};
    },
    MATCH4(4) {
        int getPrice() {return 50000;};
    },
    MATCH5(5) {
        int getPrice() {return 1500000;};
    },
    MATCH6(6) {
        int getPrice() {return 2000000000;};
    };

    private ResultTypes(int matchCount){
        this.matchCount = matchCount;
    }

    public static ResultTypes findByCode(int code) {
        return Arrays.stream(ResultTypes.values())
                .filter(result -> result.hasCode(code))
                .findAny()
                .orElse(NOMATCH);
    }

    public boolean hasCode(int code){
        return this.matchCount == code;
    }

    private int matchCount;

    abstract int getPrice();
}
