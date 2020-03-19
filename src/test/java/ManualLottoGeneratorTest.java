//package domain;
//
//import generator.LottoGenerator;
//import generator.ManualLottoGenerator;
//import org.junit.Test;
//import vo.LottoNumber;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class ManualLottoGeneratorTest {
//
//    @Test
//    public void 수동로또생성() {
//        //given
//        String lottoStr1 = "1, 2, 3, 4, 5, 6";
//        String lottoStr2 = "1, 2, 3, 4, 5, 7";
//        LottoGenerator lottoGenerator1 = new ManualLottoGenerator(lottoStr1);
//        LottoGenerator lottoGenerator2 = new ManualLottoGenerator(lottoStr2);
//
//        Lotto otherLotto = new Lotto(new ArrayList<>(
//                Arrays.asList(
//                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
//                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))
//        ));
//
//        //when
//        Lotto lotto1 = lottoGenerator1.generateLotto();
//        Lotto lotto2 = lottoGenerator2.generateLotto();
//
//        //then
//        assertThat(lotto1.equals(otherLotto)).isTrue();
//        assertThat(lotto2.equals(otherLotto)).isFalse();
//    }
//}
