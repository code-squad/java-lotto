package lotto.model;

public class MatchCount {
	private int matchCount;

	public MatchCount() {
		matchCount = 0;
	}
	
	public void addCount() {
		matchCount++;
	}
	
	public int getCount() {
		return matchCount;
	}
}