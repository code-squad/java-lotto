package domain;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void Money_값_비교() {
        assertThat(new Money(7000)).isEqualTo(new Money(7000));
    }

    @Test
    public void Money_값_비교2() {
        assertThat(new Money(7000).equals(new Money(7000))).isEqualTo(true);
    }
}