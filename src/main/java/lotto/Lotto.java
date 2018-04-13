package lotto;

import java.util.List;

public class Lotto {

    List<Integer> selectedNumbers;

    public Lotto(List<Integer> selectedNumbers) {
        this.selectedNumbers = selectedNumbers;
    }

    public List<Integer> getSelectedNumbers() {
        return selectedNumbers;
    }

}
