package dto;

public class ResultDto {
    private LottoBundleDto theLottoBundleDto;
    private int[] winStats;

    public ResultDto(LottoBundleDto theLottoBundleDto, int[] winStats) {
        this.theLottoBundleDto = theLottoBundleDto;
        this.winStats = winStats;
    }

    public int[] getWinStats() {
        return winStats;
    }

    public int getTheLottoBundleDtoSize(){
        return this.theLottoBundleDto.getTheBundleSize();
    }
}
