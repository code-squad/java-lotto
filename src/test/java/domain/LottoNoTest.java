package domain;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LottoNoTest {
    LottoNo lottoNo;

    @Test
    public void generateLottoNo() {
        lottoNo = new LottoNo(4);
        assertEquals(true, lottoNo.hasNumber(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void generateOverLottoNo() {
        new LottoNo("46");
    }

    @Test(expected = IllegalArgumentException.class)
    public void generateZeroLottoNo() {
        new LottoNo("0");
    }

    @Test
    public void getLottoNoFromString() {
        String numberLine = "1, 2, 3, 4, 5, 6";
        List<LottoNo> lottoNos = LottoNo.getLottoNosFromString(numberLine);
        LottoNo lottoNo = new LottoNo(1);
        assertEquals(lottoNo, lottoNos.get(0));
    }

    @Test
    public void insertNumbers() throws SQLException {
        LottoNo.insert(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    public void makeRandomNumbers() {
        List<Integer> numbers = LottoNo.makeRandomNumbers();
        assertEquals(6, numbers.size());
    }
}
