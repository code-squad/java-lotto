package lotto.domain;

import lotto.type.WinningType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderTest {
    private static final int TOTAL_COST = 14000;
    private Order order;

    @Test
    public void create() {
        order = new Order(TOTAL_COST, Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12"));
        order.getLottos()
                .stream()
                .forEach(System.out::println);

        assertThat(order.countOfLotto()).isEqualTo(14);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_최소금액_체크(){
        List<String> customLottoNumber = new ArrayList<>();
        order = new Order(500, customLottoNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_수동입력_null_체크(){
        order = new Order(TOTAL_COST, null);
    }
}