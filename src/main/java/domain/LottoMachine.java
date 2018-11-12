package domain;

import java.util.List;

public interface LottoMachine {
    List<Lotto> generate(Money money);
}
