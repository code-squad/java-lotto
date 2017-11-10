package com.lotto.view;

public enum ConsoleMessages {
	INPUT_PROMPT("로또 구입 금액을 입력하여 주십시오."), 
	INPUT_PROMPT_PURCHASE
	("구입 번호를 수동으로 입력하려면 manual을, 자동 생성하려면 auto를 입력해 주십시오."),
	INPUT_PROMPT_NUMBERS(
			"구입할 번호를 입력하여 주십시오. 숫자는 여섯 개를 입력하여 주시고 공백(space)으로 구분하여 주십시오."),
	INPUT_PROMPT_WINNINGTYPE("당첨 번호를 수동 입력하려면 manual을, 자동 생성하려면 auto를 입력하여 주십시오."),
	INPUT_PROMPT_WINNINGNUMBERS("당첨 번호를 입력하여 주십시오. 숫자는 여섯 개를 입력하여 주시고 공백(space)으로 구분하여 주십시오."),
	INPUT_PROMPT_BONUS("보너스 번호 한 개를 입력하여 주십시오. 1부터 45까지의 정수입니다.");

	private String msg;

	private ConsoleMessages(String msg) {
		this.msg = msg;
	}

	public String getMessage() {
		return this.msg;
	}
	
	@Override
	public String toString() {
		return this.msg;
	}

}
