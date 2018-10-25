package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private static List<LottoNum> nums = new ArrayList<>();

    static {
        for (int i = 1; i < 46; i++) {
            nums.add(LottoNum.intCreate(i));
        }
    }

    private ArrayList<Lotto> lottos = new ArrayList<>();

    public LottoFactory(int num) {
        create(num);
    }

    private void create(int num) {
        for (int i = 0; i < num; i++) {
            lottos.add(Lotto.autoLottoCreator(nums));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
