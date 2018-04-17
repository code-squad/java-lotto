package calculator;

/**
 * 요구사항
 * 1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달 --> 구분자를 기준으로 분리한 각 숫자의 합 반환("1,2,3" => 6)
 * 2. 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자 지정 가능.
 * 3. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용
 * “//;\n1;2;3” -> 커스텀 구분자는 세미콜론(;)이며 결과는 6이 반환
 * 4. 숫자 이외에 값 또는 음수 전달시 RuntimeException 예외를 throw
 */
public class StringCalculator {
    public int add(String text) {
        int sum = 0;
        String result="";
        int num1 = 0;
        int num2 = 0;

        // 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야함
        if(text == null || text.isEmpty()){
            return 0;
        }

        // 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환
        if(text.length() == 1){
            int number = Integer.parseInt(text);
            return number;
        }

        // 숫자 두개를 쉼표(,) 또는 콜론(:) 구분자로 입력할 경우 두 숫자의 합을 반환
        if(text.length() > 1){
            String[] tokens = text.split(",|:");
            String[] numbers = text.split(",");

            for(int i=0; i <= numbers.length; i++){
                num1 = Integer.parseInt(numbers[i]);
                num2 = Integer.parseInt(numbers[i+1]);
            }
            return num1 + num2;
        }
        return sum;
    }
}
