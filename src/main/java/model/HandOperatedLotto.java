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
            lottos.add(new Lotto(splitComma(lottoNumber)));
        }
        return lottos;
    }

    private List<Integer> splitComma(String result) {
        List<Integer> resultNumbers = new ArrayList();
        for (String value : result.split(",")) {
            resultNumbers.add(Integer.parseInt(value));
        }
        return resultNumbers;
    }
}
