package lotto.view;

import lotto.domain.Lotto;
import lotto.dto.WinningDTO;
import lotto.type.WinningType;

import java.util.List;

public class ResultView {
    public static void printLottos(List<Lotto> lottos){
        System.out.println(lottos.size()+"개를 구매했습니다.");

        for(Lotto lotto : lottos){
            System.out.println(lotto);
        }

    }

    public static void printWinningResult(WinningDTO winningResult){
        for(WinningType type : WinningType.values()){
            if(type.equals(WinningType.NONE)){
                continue;
            }

            System.out.println(type.getDescription()+" - "+winningResult.getWinningCount(type)+"개");
        }
        System.out.println("총 수익률은 "+String.format("%,d", winningResult.getEarningsRate())+"%입니다.");
    }

}
