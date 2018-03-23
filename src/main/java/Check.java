import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Check {
    Input input = new Input();
    List<String> rightNumber = Arrays.asList(input.right().split(","));

    public void checking(ArrayList<Lotto> lottos) {
        Input.bonusNumber();
        for(int i = 0; i < lottos.size(); i++) {
            lottos.get(i).checkNumber(rightNumber);
        }
    }
}
