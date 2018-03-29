package lotto.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import lotto.view.Print;

public class InputTest {

	@Test
	public void 정상구매() {
		assertThat(Print.checkSheets(4000), is(4));
	}

}
