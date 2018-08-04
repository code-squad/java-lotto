package lotttoOlder;

public enum LottoInfo {

  //  TODO remove mapkey
  FIRST(1, 6, "first", 2_000_000_000),
  SECOND(2, 5, "second", 1_500_000),
  THIRD(3, 4, "third", 50_000),
  FOURTH(4, 3, "fourth", 5_000);

  private int rank;
  private int matchNum;
  private String mapKey;
  private int prize;

  public static final int LOTTO_PRICE = 1000;
  public static final int LOTTO_NUM_COUNT = 6;
  public static final int LOTTO_NUM_START = 1;
  public static final int LOTTO_NUM_END = 45;

  LottoInfo(int rank, int matchNum, String mapKey, int prize) {
    this.rank = rank;
    this.matchNum = matchNum;
    this.mapKey = mapKey;
    this.prize = prize;
  }

  public int getRank() {
    return rank;
  }

  public int getMatchNum() {
    return matchNum;
  }

  public int getPrize() {
    return prize;
  }

  public String getMapKey() {
    return mapKey;
  }

  @Override
  public String toString() {
    return "LottoInfo{}";
  }

}
