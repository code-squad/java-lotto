package dto;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParsingLottoNumbersTest {
    @Test
    public void List_String_6개_생성(){
        assertThat(new ParsingLottoNumbers("1, 2, 3, 4, 5, 6").getNumbers().size(), is(6));
    }

    @Test(expected = NullPointerException.class)
    public void List_String_생성_실패(){
        assertThat(new ParsingLottoNumbers("1, 2, 3").getNumbers().size(), is(6));
    }
}
