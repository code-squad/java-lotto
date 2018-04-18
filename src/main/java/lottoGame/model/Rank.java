package lottoGame.model;

public enum Rank {
    First(1,2000000000,6,0)
    ,Second(2,1500000,5,0)
    ,thirth(3,50000,4,0)
    ,fourth(4,5000,3,0);

    private int rank;
    private int reward;
    private int matchCnt;
    private int cnt;

    Rank(int rank, int reward, int matchCnt, int cnt) {
        this.rank = rank;
        this.reward = reward;
        this.matchCnt = matchCnt;
    }

    public int getRank() {
        return rank;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCnt() {
        return matchCnt;
    }

    public int getCnt() {
        return cnt;
    }

    public boolean isMatch(int winCnt) {
        if(winCnt == matchCnt){
            cnt++;
            return true;
        }

        return false;
    }
}
