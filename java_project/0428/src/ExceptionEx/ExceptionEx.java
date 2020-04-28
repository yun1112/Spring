package ExceptionEx;

import java.util.Scanner;

public class ExceptionEx {
	public static void main(String[] args) throws AgeInputExecption {// 메인메서드에서 예외 처리하지 않고 메서드 호출한 쪽에 던짐
		try {
			int age = readAge();

			System.out.println("나이는 " + age + "살 입니다");
		} catch (AgeInputExecption e) {
			System.out.println("에러 메시지: " + e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("에러 메시지: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램이 정상 종료되었습니다");
	}

	static int readAge() throws AgeInputExecption {
		Scanner sc = new Scanner(System.in);

		System.out.println("나이를 입력하세요");
		int age = sc.nextInt();

		if (age < 0) {
			AgeInputExecption e = new AgeInputExecption();
//			Exception e=new Exception("고의로 발생시킴");//Exception클래스에 메시지값 전달
			throw e;// 예외 발생 지점
		}
		return age;
	}
}
