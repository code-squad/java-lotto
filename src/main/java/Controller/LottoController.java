package Controller;

import domaim.LottoGame;
import dto.LottoDto;
import dto.RewardDto;
import view.InputView;
import view.ResultView;

public class LottoController {
    public static void main(String[] args)  {
        LottoGame lottoGame = new LottoGame(InputView.getPay());
        LottoDto lottoDto = lottoGame.createLottoDto();
        ResultView.showLottoNum(lottoDto);
        ResultView.showLottoList(lottoDto);

        RewardDto rewardDto = lottoGame.createRewardDto(InputView.getWinningNum());
        ResultView.showWinStats(rewardDto);
        ResultView.showProfit(rewardDto);
    }
}
