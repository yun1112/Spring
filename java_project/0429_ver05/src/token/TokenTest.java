package token;

import java.util.StringTokenizer;

public class TokenTest {

	public static void main(String[] args) {
		String phoneNumber = "Tel 82-02-997-2059 test";

		StringTokenizer st1 = new StringTokenizer(phoneNumber);

		while (st1.hasMoreTokens()) {// 다음 요소가 있는지 여부를 확인->true/false 반환
			System.out.println(st1.nextToken());// 생성자에 구분자를 넣지 않으면 탭/스페이스/엔터(공백 관련 문자)로 구분해서 반환함
		}

		System.out.println("---------------------------------------------");
		System.out.println(phoneNumber);
		System.out.println("---------------------------------------------");
		StringTokenizer st2 = new StringTokenizer(phoneNumber, "  -");
//		StringTokenizer st2 = new StringTokenizer(phoneNumber, "  -",true);
		while (st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}

	}
}
