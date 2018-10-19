package utils;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class NumParserTest {

    @Test
    public void parse() {
        assertThat(Arrays.asList(1,2,3,4,5,6)).isEqualTo(NumParser.parse("1, 2, 3, 4, 5, 6"));
    }
}