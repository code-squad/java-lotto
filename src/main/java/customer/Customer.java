package customer;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Customer {
    private static final Integer LOTTO_PRICE = 1000;

    private List<Lotto> lottos = new ArrayList();

    public List<Lotto> buy(Integer amount) {
        Integer number = amount / LOTTO_PRICE;

        for (int i = 0; i < number; i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

    public List<Integer> getHitNumbers(String result) {
        List<Integer> numberOfHit = new ArrayList();

        for (Lotto lotto : lottos) {
            List<Integer> lastWeekResultNumbers = getResultValue(result);
            numberOfHit.add(lotto.compare(lastWeekResultNumbers));
        }

        return numberOfHit;
    }

    private List<Integer> getResultValue(String result) {
        List<Integer> resultNumbers = new ArrayList();
        for (String value : result.split(",")) {
            resultNumbers.add(Integer.parseInt(value));
        }
        return resultNumbers;
    }

    public Double analyze(List<Integer> hitNumbers) {
        List<Integer> hitResult = countHit(hitNumbers);
        Integer loseAmount = lottos.size() * LOTTO_PRICE;
        Integer profit = (hitResult.get(0) * 5000) + (hitResult.get(1) * 50000) + (hitResult.get(2) * 1500000) + (hitResult.get(3) * 2000000000);

        return (double)(profit - loseAmount) / (double)loseAmount * 100;
    }

    public List<Integer> countHit(List<Integer> hitNumbers) {
        Integer hitThree = 0;
        Integer hitFour = 0;
        Integer hitFive = 0;
        Integer hitSix = 0;

        for (Integer hitNumber : hitNumbers) {
            if(hitNumber.equals(3)){
                hitThree ++;
            }

            if(hitNumber.equals(4)){
                hitFour ++;
            }

            if(hitNumber.equals(5)){
                hitFive ++;
            }

            if(hitNumber.equals(6)){
                hitSix ++;
            }
        }

        return Arrays.asList(hitThree, hitFour, hitFive, hitSix);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
