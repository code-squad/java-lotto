package domain.lotto;

public interface Validable<T> {
    boolean isValidData(T data);
}
