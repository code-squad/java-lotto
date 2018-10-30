package domain;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoBundleFactoryTest {
    @Test
    public void generateLottoBundle() {
        List<String> list = new ArrayList<>();
        String s = "1,2,3,4,5,6";
        list.add(s);
        LottoBundleFactory auto = new AutoLottoBundleFactory();
        LottoBundleFactory manual = new ManualLottoBundleFactory(list);

        LottoBundle theLottoBundle = manual.generate(1).addAll(auto.generate(10));
        System.out.println(theLottoBundle);
    }
}
