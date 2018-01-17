package model;

import java.util.Arrays;

public enum ResultTypes {

    NO_MATCH(0) {
        public int getPrice() {return 0;}
    },
    MATCH3(3) {
        public int getPrice() {return 5000;}
    },
    MATCH4(4) {
        public int getPrice() {return 50000;}
    },
    MATCH5(5) {
        public int getPrice() {return 1500000;}
    },
    MATCH6(6) {
        public int getPrice() {return 2000000000;}
    };

    ResultTypes(int matchCount){
        this.matchCount = matchCount;
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

    public abstract int getPrice();
}
