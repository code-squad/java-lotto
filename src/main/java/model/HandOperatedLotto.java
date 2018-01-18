package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class HandOperatedLotto {
    private Integer numberOfLotto;
    private List<Lotto> lottos;

    public HandOperatedLotto(Integer numberOfLotto, String[] lottoNumbers) {
        this.numberOfLotto = numberOfLotto;
        this.lottos = new ArrayList();
        this.lottos = buyLotto(lottoNumbers);
    }

    private List<Lotto> buyLotto(String[] lottoNumbers) {
        for (String lottoNumber : lottoNumbers) {
            lottos.add(new Lotto(StringUtil.stringToList(lottoNumber)));
        }
        return lottos;
    }

}
