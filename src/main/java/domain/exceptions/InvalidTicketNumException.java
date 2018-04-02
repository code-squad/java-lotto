package domain.exceptions;

public class InvalidTicketNumException extends LottoProcessException {
    public InvalidTicketNumException(String s){
        super(s);
    }
}
