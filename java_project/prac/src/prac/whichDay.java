package prac;

import java.util.Scanner;

public class whichDay {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mon = sc.nextInt();// 출력할 월 입력
		int day = sc.nextInt();// 출력할 일 입력
		sc.close();// 입력 종료
		int cnt = 0;// 요일을 계산하기 위한 변수

//		인덱스와 달의 숫자를 맞추기 위해 인덱스0번은 0으로 두고 인덱스 0번부터 1~12월의 전체 날짜수를 배열에 저장함
		int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int i = 1; i < mon; i++) {
			cnt += days[i];// 출력할 달까지의 전체 날짜수 계산
		}

		switch (cnt % 7) {// 헤딩하는 요일을 계산하기 위해서 전체 날짜 수를 일주읠의 총 날짜수인 7로 나눔
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wendsday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		case 0:
			System.out.println("Sunday");
			break;
		default:
			break;
		}
	}

}
