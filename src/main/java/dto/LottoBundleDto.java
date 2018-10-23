package dto;

import java.util.ArrayList;
import java.util.List;

public class LottoBundleDto {
    private List<LottoDto> theBundle = new ArrayList<>();

    public void add(LottoDto aLottoDto){
        this.theBundle.add(aLottoDto);
    }

    public List<LottoDto> getTheBundle(){
        return this.theBundle;
    }
}
