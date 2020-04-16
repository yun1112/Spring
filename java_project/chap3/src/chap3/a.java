package chap3;

public class a {

	public static void main(String[] args) {
		int a = 1000000, b = 2000000;
		long c = (long) a * b;
		System.out.println(c);

		long aa = (long) 1000000 * 1000000, bb = 1000000 * 1000000L;
		System.out.println(aa);
		System.out.println(bb);

		char c1 = 'a', c2 = (char) (c1 + 1), c3 = 'a' + 1;
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

		char C = 'a';

		for (int i = 0; i < 26; i++) {
			System.out.println(C++);
		}

		char CC = '0';
		for (int i = 0; i < 10; i++) {
			System.out.println(C++);
		}

		char lowerCase = 'a';// ascii code of 'a' is 97
		char upperCase = (char) (lowerCase - 32);// ascii code of capital letter 'A' is 65
		System.out.println(upperCase);

		float pi = 3.141592f;
		float shortPi = (int) (pi * 1000) / 1000f;
		System.out.println(shortPi);

		System.out.println(Math.round(pi * 1000) / 1000f);// 소숫점 첫째자리에서 반올림

		System.out.println(10.0 == 10.0f);

		float f = 0.1f;
		double d = 0.1, d2 = (double) f;
		
		System.out.println(d==f);
		System.out.println(d==d2);
		System.out.println(d2==f);
	}

}
