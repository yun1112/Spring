package inheritance;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FriendMain {

	public static void main(String[] args) {
		FriendInfoHandler handler = FriendInfoHandler.getinstance();
		int choice=0;

		while (true) {
			System.out.println("------------------------메뉴를 선택해주세요");
			System.out.println(Menu.INSERT_HIGH+".고교 친구 저장");
			System.out.println(Menu.INSERT_UNIV+".대학 친구 저장");
			System.out.println(Menu.PRINT_BASIC+".기본 정보 출력");
			System.out.println(Menu.PRINT_ALL+".전체 정보 출력");
			System.out.println(Menu.EXIT+".종료");
			System.out.println("------------------------------------------------");
			//인터페이스 상수 숫자 오류 문제 해결해야됨
			//1~5까지만 입력되어야 하기 때문에 프로그램 논리적 오류 발생
			//사용자 정의 Exception 클래스 만들어서 예외 정의/처리해야함
			
			Scanner sc=new Scanner(System.in);
			//try-catch문(입력된 값이 정수 아닐 경우)
			try {
				choice = sc.nextInt();
				//.nextInt()에서 예외 발생하면 여기서 발생한 타입의 인스턴스 catch문에 보냄
			}catch(InputMismatchException e) {//InputMismatchException의 상위클래스 Exception
				System.out.println("정상적인 번호 입력이 되지 않았습니다");
				System.out.println("메뉴를 다시 입력해주세요");
				sc.hasNextLine();
				continue;
			}catch(Exception e) {
				System.out.println("예외 발생");
				sc.hasNextLine();//버퍼 클리어
				continue;
			}
//			handler.sc.hasNextLine();// 앞의 버퍼 클리어 목적
			
			//switch문 전체를 try~catch문으로 묶음->예외 처리후 continue로 다시 처음 부분으로 돌아감
			switch (choice) {
			case Menu.INSERT_HIGH: case Menu.INSERT_UNIV:
				handler.addFriend(choice);
				break;
			case Menu.PRINT_BASIC:
				handler.showAllSimpleData();
				break;
			case Menu.PRINT_ALL:
				handler.showAllData();
				break;
			case Menu.EXIT:
				System.out.println("프로그램을 종료합니다");
				return;
			}

		}
	}

}
