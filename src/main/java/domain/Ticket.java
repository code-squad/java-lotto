package domain;

import java.util.List;

public class Ticket {
    private List<Integer> nums;

    public Ticket(List<Integer> nums) {
        this.nums = nums;
    }

    public List<Integer> getNums() {
        return nums;
    }
}
