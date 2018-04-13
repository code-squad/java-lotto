package lotto.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringFormatMatchUtilsTest {
	@Test
	public void matchNumberFormat테스트() {
		assertThat(StringFormatMatchUtils.matchNumberFormat("kk")).isEqualTo(false);
		assertThat(StringFormatMatchUtils.matchNumberFormat("0")).isEqualTo(true);
	}
	
	@Test
	public void matchNumbersFormat테스트() {
		assertThat(StringFormatMatchUtils.matchNumbersFormat("1, 2,3")).isEqualTo(true);
		assertThat(StringFormatMatchUtils.matchNumbersFormat("1,2,3")).isEqualTo(true);
		assertThat(StringFormatMatchUtils.matchNumbersFormat("1, 2,3,")).isEqualTo(false);
		assertThat(StringFormatMatchUtils.matchNumbersFormat("1,,,, 2,3")).isEqualTo(false);
		assertThat(StringFormatMatchUtils.matchNumbersFormat("1 2,3")).isEqualTo(false);
	}
}
