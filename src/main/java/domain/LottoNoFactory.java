package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNoFactory {
    public static LottoNo getLottoNo(int number) {
        return new LottoNo(number);
    }

    public static LottoNo getLottoNo(String number) {
        return new LottoNo(number);
    }

    public static List<LottoNo> getLottoNo(List<Integer> numbers) {
        List<LottoNo> lottoNos = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNos.add(LottoNoFactory.getLottoNo(number));
        }
        return lottoNos;
    }
}
