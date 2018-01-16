# 로또

## Step1
* repo : https://github.com/trytocloud/java-lotto/tree/step1
* pr : https://github.com/code-squad/java-lotto/pull/22

### 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

### 실행 결과
````
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[3, 14, 23, 36, 41, 44]
[2, 7, 8, 9, 21, 38]
[4, 5, 23, 24, 38, 42]
[3, 9, 16, 33, 34, 42]
[2, 4, 15, 25, 29, 42]
[14, 16, 24, 32, 33, 41]
[2, 8, 13, 23, 41, 45]
[2, 19, 22, 23, 38, 40]
[1, 6, 10, 19, 35, 44]
[14, 21, 27, 30, 32, 44]
[4, 5, 23, 29, 34, 45]
[9, 14, 26, 27, 31, 36]
[3, 6, 12, 27, 38, 42]
[2, 9, 13, 21, 26, 32]
지난 주 당첨 번호를 입력해 주세요.
2, 9, 13, 27, 33, 41
당첨 통계
---------
3개 일치 (5000원)- 2개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개

총 수익률은 -29%입니다
````

### 프로그래밍 요구사항
* 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외

## Step2
* repo : https://github.com/trytocloud/java-lotto/tree/step2
* pr : https://github.com/code-squad/java-lotto/pull/27

### 기능 요구사항
* 2등을 위해 추가 번호를 하나 더 추첨한다.
* 당첨 통계에 2등도 추가해야 한다.

### 실행 결과
````
[... 생략 ...]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 30%입니다.
````
### 프로그래밍 요구사항
* 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
* java enum을 적용해 프로그래밍을 구현한다.
* 규칙 8: 일급 콜렉션을 쓴다.

## Step3
* repo : https://github.com/trytocloud/java-lotto/tree/step3
* pr : 

### 기능 요구사항
* 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
* 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

### 실행 결과
````
구입금액을 입력해 주세요.
14000

수동으로 구매할 로또 수를 입력해 주세요.
3

수동으로 구매할 번호를 입력해 주세요.
8, 21, 23, 41, 42, 43
3, 5, 11, 16, 32, 38
7, 11, 16, 35, 36, 44

수동으로 3장, 자동으로 11장을 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 30%입니다.
````

### 프로그래밍 요구사항
* 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
* java enum을 적용해 프로그래밍을 구현한다.
* 예외 처리를 통해 에러가 발생하지 않도록 한다.
* 규칙 3: 모든 원시값과 문자열을 포장한다.
* 규칙 5: 줄여쓰지 않는다(축약 금지).
* 규칙 8: 일급 콜렉션을 쓴다.
