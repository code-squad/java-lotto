public class Positive {

    int number;

    Positive(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
