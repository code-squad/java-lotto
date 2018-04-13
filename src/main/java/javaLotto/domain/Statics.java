package javaLotto.domain;

public class Statics {
    private int grade;
    private int prizeMoney;
    private int count;

    public Statics(int grade, int prizeMoney, int count) {
        this.grade = grade;
        this.prizeMoney = prizeMoney;
        this.count = count;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getGrade() {
        return grade;
    }

    public int getCount() {
        return count;
    }
}
