package test;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumTest {
    @Test
    public void createTest(){
        TheEnum aEnum = TheEnum.valueOf("FIRST");
        assertThat(aEnum.getNumber()).isEqualTo(1);
        assertThat(aEnum.getMessage()).isEqualTo("hello");

        for (TheEnum theEnum : TheEnum.values()) {
            System.out.println(theEnum.getNumber());
            System.out.println(theEnum.getMessage());
        }

    }

    @Test
    public void isEqual(){
        assertThat(TheEnum.FIRST).isEqualTo(TheEnum.valueOf("FIRST"));
    }
}
