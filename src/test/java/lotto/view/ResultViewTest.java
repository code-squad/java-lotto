package lotto.view;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ResultViewTest {

    @Test
    public void price() {
        int a = 5000;
        assertThat(ResultView.price(a)).isEqualTo(5);
    }

    @Test
    public void randomPrice() {
        int a = 5000;
        int b = 3;

        System.out.println(ResultView.randomPrice(a,b));

        assertThat(ResultView.randomPrice(a, b)).isEqualTo(2);
    }
}