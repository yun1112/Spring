package chap3;

public class assignment5 {

	public static void main(String[] args) {

		String str = "12345";

		int sum = 0;

		int num = Integer.parseInt(str);// 문자열 str를 정수형 변수 num으로 변환

		for (int i = 0; i < str.length(); i++) {

			sum += (num % 10);// 1의자리부터 더해나감
			num /= 10;
		}

		System.out.println(sum);

	}

}