package ex;

import java.util.Scanner;

public class FriendMain {
	public static void main(String[] args) {
		FriendInfoHandler handler = FriendInfoHandler.getInstance();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("------------------------메뉴를 선택해주세요");
			System.out.println(Menu.INSERT_HIGH + ".고교 친구 저장");
			System.out.println(Menu.INSERT_UNIV + ".대학 친구 저장");
			System.out.println(Menu.PRINT_BASIC + ".기본 정보 출력");
			System.out.println(Menu.PRINT_ALL + ".전체 정보 출력");
			System.out.println(Menu.SEARCH_INFO + ".친구 정보 검색");
			System.out.println(Menu.MODIFY_INFO + ".친구 정보 수정");
			System.out.println(Menu.DELETE_INFO + ".친구 정보 삭제");
			System.out.println(Menu.EXIT + ".종료");
			System.out.println("------------------------------------------------");
			int type = sc.nextInt();
			switch (type) {
			case Menu.INSERT_HIGH:
				handler.SaveFreinds(type);
				break;
			case Menu.INSERT_UNIV:
				handler.SaveFreinds(type);
				break;
			case Menu.PRINT_BASIC:
				handler.printBasic();
				break;
			case Menu.PRINT_ALL:
				handler.printAll();
				break;
			case Menu.SEARCH_INFO:
				handler.searchFriends();
				break;
			case Menu.MODIFY_INFO:
				handler.modifyFriends();
				break;
			case Menu.DELETE_INFO:
				handler.deleteFriends();
				break;
			case Menu.EXIT:
				return;
			}
		}
	}
}
