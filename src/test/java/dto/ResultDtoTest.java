package dto;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ResultDtoTest {
    @Test
    public void pushResultTest() {
        ResultDto resultDto = new ResultDto();
        resultDto.pushResult(6);
        resultDto.pushResult(5);
        resultDto.pushResult(5);

        assertThat(resultDto.getResult().get(6)).isEqualTo(1);
        assertThat(resultDto.getResult().get(5)).isEqualTo(2);
        assertThat(resultDto.getResult().get(4)).isEqualTo(0);
    }
}