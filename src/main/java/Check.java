import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Check {
    Input input = new Input();
    String rightInput = input.right();
    List<String> rightNumber = Arrays.asList(rightInput.split(","));

    public ArrayList<String> addingBonus() {
        Input.bonusNumber();
        ArrayList<String> bonusAdding = new ArrayList<>(rightNumber);
        bonusAdding.add(input.bonusInput());
        return bonusAdding;
    }

    public void checking(ArrayList<Lotto> lottos) {
        ArrayList<String> bonusAdding = addingBonus();
        for(int i = 0; i < lottos.size(); i++) {
            lottos.get(i).checkNumber(bonusAdding);
        }
    }
}
