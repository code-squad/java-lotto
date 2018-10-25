package dto;

import java.util.List;

public class UserLottoDto {
    private List<LottoDto> userLottoDto;

    public UserLottoDto(List<LottoDto> userLottoDto) {
        this.userLottoDto = userLottoDto;
    }

    public List<LottoDto> getUserLottoDto() {
        return userLottoDto;
    }
}
