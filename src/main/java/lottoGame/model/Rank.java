package lottoGame.model;

public enum Rank {
    FIRST(2000000000,6,0)
    ,SECOND(1500000,5,0)
    ,THIRTH(50000,4,0)
    ,FOURTH(5000,3,0);

    private int reward;
    private int matchCnt;
    private int cnt;

    Rank(int reward, int matchCnt, int cnt) {
        this.reward = reward;
        this.matchCnt = matchCnt;
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
