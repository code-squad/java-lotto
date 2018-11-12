package domain;

import utils.LottoGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoMachine implements LottoMachine {
    private AutoLottoMachine autoLottoMachine = new AutoLottoMachine();
    private String inputLottos;

    public ManualLottoMachine(String inputLottos) {
        this.inputLottos = inputLottos;
    }

    public static List<Lotto> generateLottos(String inputLottos) {
        return Arrays.stream(inputLottos.split("\r?\n"))
                .map(s -> Lotto.ofComma(s))
                .collect(Collectors.toList());
    }

    @Override
    public List<Lotto> generate(Money money) {
        List<Lotto> manualLottos = generateLottos(inputLottos);
        Money leftMoney = money.spendAfterMoney(manualLottos.size());
        List<Lotto> autoLottos = autoLottoMachine.generate(leftMoney);
        manualLottos.addAll(autoLottos);
        return manualLottos;
    }

}
