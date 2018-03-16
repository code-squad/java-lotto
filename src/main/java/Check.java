import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Check {
    Input input = new Input();
    String rightInput = input.right();
    List<String> rightNumber = Arrays.asList(rightInput.split(","));

    public void checking(ArrayList<Lotto> lottos) {
        for(int i = 0; i < lottos.size(); i++) {
            lottos.get(i).checkNumber(rightNumber);
        }
    }
}
