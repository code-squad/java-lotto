package domain;

import domain.vo.LottoNum;

import java.util.ArrayList;
import java.util.Arrays;
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

    public LottoFactory() {
        // 수동 로또 생성
    }


    private LottoFactory(List<String> manualLottos, int count) {
        for (String manualLotto : manualLottos) {
            List<String> lotto = new ArrayList<>(Arrays.asList(manualLotto.replace(" ", "").split(",")));
            addManualLotto(lotto);
        }
        // 수동 로또 생성
        addAutoLotto(count - lottos.size());
    }

    LottoFactory(int num) {
        addAutoLotto(num);
    }

    public void addManualLotto(List<String> list) {
        lottos.add(Lotto.ofManual(list));
    }


    public void addAutoLotto(int num) {
        for (int i = 0; i < num; i++) {
            Collections.shuffle(nums);
            lottos.add(Lotto.ofAuto(nums.stream()
                    .limit(6)
                    .collect(Collectors.toList())));
        }
    }

    public static LottoFactory of(List<String> manualLottos, int count) {
        return new LottoFactory(manualLottos, count);
    }


    public List<Lotto> getLottos() {
        return lottos;
    }
}
