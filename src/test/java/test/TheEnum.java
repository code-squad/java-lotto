package test;

public enum TheEnum {
    FIRST(1, "hello"),
    SECOND(2, "hi"),
    THIRD(3, "bye");

    private int number;
    private String message;

    TheEnum(int number, String message){
        this.number = number;
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    public String getMessage() {
        return message;
    }
}
