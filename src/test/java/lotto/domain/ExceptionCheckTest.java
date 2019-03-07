package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ExceptionCheckTest {

    @Test
    public void a (){
        int a = 5300;
        int b = 137000;

        assertThat(ExceptionCheck.money(a)).isEqualTo(false);
        assertThat(ExceptionCheck.money(b)).isEqualTo(true);
    }

}