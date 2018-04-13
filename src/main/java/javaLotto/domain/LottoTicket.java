package javaLotto.domain;

import java.util.*;

public class LottoTicket {
    private List<Integer> lottoTicket = new ArrayList<>();

    public LottoTicket(List<Integer> lottoTicket) {
        validation(lottoTicket.size() > 6, "로또 번호는 6개 이하이여야 합니다.");
        for(int number : lottoTicket){
            validation(number > 45 || number < 1, "로또 번호는 1~45 사이여야 합니다.");
        }
        for (int i = 0; i < lottoTicket.size() ; i++) {

        }
       compareNumber(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    private void compareNumber(List<Integer> lottoTicket) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < lottoTicket.size() ; i++) {
            if(!result.contains(lottoTicket.get(i))){
                result.add(lottoTicket.get(i));
            }else{
                throw new IllegalArgumentException("로또 번호는 중복 될 수 없습니다.");
            }
        }
    }

    private void validation(boolean b, String s) {
        if (b) {
            throw new IllegalArgumentException(s);
        }
    }

    public List<Integer> getLottoTicket() {
        return lottoTicket;
    }

    public static int matchCount(List<Integer> winningNumber ,LottoTicket lotto) {
            int matchCount = 0;
            for (int number : winningNumber){
                if(lotto.getLottoTicket().contains(number)){
                    matchCount++;
                }
            }
        return matchCount;
    }

    public static boolean matchBonus(int bonusBall, LottoTicket lottoTicket) {
        return lottoTicket.getLottoTicket().contains(bonusBall);
    }

    public static List<Integer> printTicket(LottoTicket ticket) {
        return ticket.getLottoTicket();
    }
}
