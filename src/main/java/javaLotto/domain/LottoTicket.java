package javaLotto.domain;

import java.util.*;

public class LottoTicket {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private  Set<LottoNo> lottoTicket;

    public LottoTicket(Set<LottoNo> lottoTicket) {
        if(lottoTicket.size() != LOTTO_NUMBER_SIZE){
            throw new IllegalArgumentException("로또 숫자의 사이즈는 6개여야 합니다.");
        }
        this.lottoTicket = lottoTicket;
    }

    public Set<LottoNo> getLottoTicket() {
        return lottoTicket;
    }

    public static int matchCount(Set<LottoNo> winningNumber ,LottoTicket lotto) {
        int matchCount = 0;
        for (LottoNo number : winningNumber){
            matchCount += addCheck(lotto,number);
        }
        return matchCount;
    }

    private static int addCheck(LottoTicket lotto, LottoNo number) {
        if(lotto.getLottoTicket().contains(number)){
            return 1;
        }
        return 0;
    }

    public static boolean matchBonus(int bonusBall, LottoTicket lotto) {
           return lotto.getLottoTicket().stream().anyMatch(no -> no.getNo() == bonusBall);
    }

    public static void printTicket(LottoTicket ticket) {
        ticket.getLottoTicket().stream().forEach(n -> System.out.print(n.getNo() + " "));
        System.out.println();
    }
}
