package lotto;

import dto.*;

import java.util.*;

public class UserLotto {
    private List<Lotto> userLottos = new ArrayList<>();

    public UserLotto(int count) {
        for (int i = 0; i < count; i++) {
            userLottos.add(new Lotto());
        }
    }

    public UserLottoDto toDto() {
        List<LottoDto> userLottoDto = new ArrayList<>();
        for (Lotto lotto : userLottos) {
            userLottoDto.add(lotto.toDto());
        }
        return new UserLottoDto(userLottoDto);
    }

}















