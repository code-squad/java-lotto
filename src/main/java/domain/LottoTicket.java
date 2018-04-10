package domain;

import java.util.List;

public class LottoTicket {
    private final String LEFT_BRACKET = "[";
    private final String RIGHT_BRACKET = "]";
    private final String COMMA_SAPERATOR = ", ";
    private static final int LOTTO_MAX_SIZE = 6;

    private List<LottoNo> numbers;

    public LottoTicket(List<LottoNo> numbers) throws Exception {
        if (!isValid(numbers)) {
            throw new IllegalArgumentException("로또 번호 6개를 입력해 주세요.");
        }
        LottoDAO lottoDAO = LottoDAO.getInstance();
        lottoDAO.insertNo(numbers);
        this.numbers = numbers;
    }

    public String getName() {
        return "name is here";
    }

    public String getLottoTicket() {
        return this.toString();
    }

    public static LottoTicket getLottoTicket(List<LottoNo> lottoNos) throws Exception {
        return new LottoTicket(lottoNos);
    }

    public boolean contains(LottoNo number) {
        return numbers.contains(number);
    }

    public boolean isValid(List<LottoNo> numbers) {
        if (numbers.size() != LOTTO_MAX_SIZE) {
            throw new IllegalArgumentException("로또 번호 6개를 입력해 주세요.");
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LEFT_BRACKET);
        for (LottoNo lottoNo : numbers) {
            sb.append(lottoNo.toString());
            sb.append(COMMA_SAPERATOR);
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(RIGHT_BRACKET);
        return sb.toString();
    }
}