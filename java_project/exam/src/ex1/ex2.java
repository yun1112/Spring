package ex1;

public class ex2 {

	public static void main(String[] args) {
		int code = 65, code1 = 'Z';// 대문자 A 유니코드값 65
		char ch = (char) code;
		int num = code1;// 대문자 Z 유니코드값 90, 자동형변환 발생
		char uni = '\u0041';// 대문자 A 유니코드값
		int ascii = 0x0041;// 대문자 A 16진법

		System.out.println(code);
		System.out.println(code1);
		System.out.println(uni);
		System.out.println(ascii);
		System.out.println(ch);
		System.out.println(num);
	}

}
