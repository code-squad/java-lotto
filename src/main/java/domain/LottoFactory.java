package domain;

import domain.vo.LottoNum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {
    private static List<LottoNum> nums = new ArrayList<>();

    static {
        for (int i = 1; i < 46; i++) {
            nums.add(LottoNum.ofInt(i));
        }
    }

    private ArrayList<Lotto> lottos = new ArrayList<>();

    public LottoFactory(int num) {
        of(num);
    }

    private void of(int num) {
        for (int i = 0; i < num; i++) {
            Collections.shuffle(nums);
            lottos.add(Lotto.ofAuto(nums.stream()
                    .limit(6)
                    .collect(Collectors.toList())));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
