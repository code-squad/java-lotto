package utils;

import dto.LottoResult;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RevenueCalculatorTest {

    private List<LottoResult> result;

    @Before
    public void setUp() throws Exception {
        result = Arrays.asList(new LottoResult(3, false),
                               new LottoResult(1, false),
                               new LottoResult(4, false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculate_결과가빈리스트인경우() throws Exception {
        RevenueCalculator.calculate(Collections.emptyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculate_결과가널인경우() throws Exception {
        RevenueCalculator.calculate(null);
    }

    @Test
    public void calculate() throws Exception {
        assertThat(RevenueCalculator.calculate(result)).isEqualTo((50000 + 5000) / (double) 3000 * 100);
    }
}