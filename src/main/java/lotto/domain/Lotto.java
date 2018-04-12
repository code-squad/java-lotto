package lotto.domain;

public class Lotto {
	public static final int LOTTO_PRICE = 1000;
	public static final int LOTTO_NUMBERS_SIZE = 6;
	private LottoNumbers lottoNumbers;
	
	public Lotto(LottoNumbers lottoNumbers) {
		validateLottoNumbers(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
	}
	
	public Lotto(LottoNumber... lottoNumbers) {
		LottoNumbers inputLottoNumbers = new LottoNumbers(lottoNumbers);
		validateLottoNumbers(inputLottoNumbers);
		this.lottoNumbers = inputLottoNumbers;
	}
	
	public LottoNumbers getLottoNumbers() {
		return lottoNumbers;
	}

	public boolean contains(LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}

	private void validateLottoNumbers(LottoNumbers lottoNumbers) {
		if(lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException("Lotto는 6개의 번호를 가져야 합니다.");
		}
	}
}
