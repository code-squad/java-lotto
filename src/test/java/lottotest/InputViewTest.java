package lottotest;

import view.InputView;
import org.junit.Test;

import java.util.*;

public class InputViewTest {
    @Test
    public void splitTest(){
        String a = "     1,     2,   3,    4,       5, 6     ";
        String[]b = a.replace(" ","").split(",");
        System.out.println(Arrays.toString(b));
    }

    @Test
    public void intputWinningNumberTest(){
        InputView.intputWinningNumber();
    }

    @Test
    public void InputViewTest(){
        System.out.println(InputView.inputPrice());
    }
}
