package sparkpractice;

public class LottoSpark {
    private int inputMoney;
    private int manualNumber;

    public int getInputMoney() {
        return inputMoney;
    }

    public void setInputMoney(String inputMoney) {
        this.inputMoney = Integer.parseInt(inputMoney);
    }

    public int getManualNumber() {
        return manualNumber;
    }

    public void setManualNumber(String manualNumber) {
        this.manualNumber = Integer.parseInt(manualNumber);
    }
}
