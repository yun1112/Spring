package inheritance;

import java.util.Scanner;

public class FriendMain {

	public static void main(String[] args) {
		FriendInfoHandler handler = FriendInfoHandler.getinstance();
		int choice;

		while (true) {
			System.out.println("------------------------메뉴룰 선택해주세요");
			System.out.println(Menu.INSERT_HIGH+".고교 친구 저장");
			System.out.println(Menu.INSERT_UNIV+".대학 친구 저장");
			System.out.println(Menu.PRINT_BASIC+".기본 정보 출력");
			System.out.println(Menu.PRINT_ALL+".전체 정보 출력");
			System.out.println(Menu.EXIT+".종료");
			System.out.println("------------------------------------------------");

			Scanner sc=new Scanner(System.in);
			choice = sc.nextInt();
			sc.hasNextLine();
//			handler.sc.hasNextLine();// 앞의 버퍼 클리어 목적
			
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
