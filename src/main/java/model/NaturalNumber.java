package model;

public class NaturalNumber {
    private int number;

    public NaturalNumber(){

    }

    public NaturalNumber(int number) throws IllegalArgumentException {
        if (number <= 0)
            throw new IllegalArgumentException("Invalid number. It must be greater than 0.");
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public int getNumber() {
        return this.number;
    }

    public boolean isLessThan(NaturalNumber n) {
        return this.number < n.number;
    }
}
