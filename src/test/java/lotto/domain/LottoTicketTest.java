package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Moonchan on 2018. 1. 16..
 */
public class LottoTicketTest {

    @Test
    public void 수동번호생성() {
        LottoTicket lottoNumber = new LottoTicket(new ManualLottoNumberGenerator(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumber.getNumbers().size()).isEqualTo(6);
        assertThat(lottoNumber.getNumbers().stream().distinct().count()).isEqualTo(6);
        assertThat(lottoNumber.getSource()).isEqualTo(LottoTicket.Source.MANUAL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 수동번호생성_잘못된숫자갯수() {
        LottoTicket lottoNumber = new LottoTicket(new ManualLottoNumberGenerator(1, 2, 3, 4, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 수동번호생성_중복숫자() {
        LottoTicket lottoNumber = new LottoTicket(new ManualLottoNumberGenerator(1, 2, 3, 4, 5, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 수동번호생성_범위를_넘어가는_숫자() {
        LottoTicket lottoNumber = new LottoTicket(new ManualLottoNumberGenerator(1, 2, 3, 4, 5, 46));
    }

    @Test
    public void 자동번호생성() {
        LottoTicket lottoNumber = new LottoTicket();
        assertThat(lottoNumber.getNumbers().size()).isEqualTo(6);
        assertThat(lottoNumber.getNumbers().stream().distinct().count()).isEqualTo(6);
        assertThat(lottoNumber.getSource()).isEqualTo(LottoTicket.Source.AUTO);
    }

    @Test
    public void 다른로또번호와비교() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(6, 7, 8, 9, 10, 11);
        List<Integer> numbers3 = Arrays.asList(7, 8, 9, 10, 11, 12);
        LottoTicket lottoNumber1 = new LottoTicket(new ManualLottoNumberGenerator(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumber1.countMatchNumber(numbers1)).isEqualTo(6);
        assertThat(lottoNumber1.countMatchNumber(numbers2)).isEqualTo(1);
        assertThat(lottoNumber1.countMatchNumber(numbers3)).isEqualTo(0);
    }
}