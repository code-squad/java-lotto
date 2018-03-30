package domain;

import java.util.List;

public class WinningLotto extends Lotto{

    private final Number bonusNumber;

    private WinningLotto(List<Integer> numbers, Number bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> numbers, Number bonusNumber){
        return new WinningLotto(numbers, bonusNumber);
    }

    public Number getBonusNumber(){
        return bonusNumber;
    }

}
