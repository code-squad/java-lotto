package domain;

import java.util.List;

public class Ticket {
    private List<LottoNo> nums;

    public Ticket(List<LottoNo> nums) {
        this.nums = nums;
    }

    public List<LottoNo> getNums() {
        return nums;
    }

    public Lotto createLotto() {
        return new Lotto(() -> nums);
    }
}
