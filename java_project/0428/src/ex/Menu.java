package ex;

/*			System.out.println("------------------------메뉴룰 선택해주세요");
			System.out.println(Menu.INSERT_HIGH+".고교 친구 저장");
			System.out.println(Menu.INSERT_UNIV+".대학 친구 저장");
			System.out.println(Menu.PRINT_BASIC+".기본 정보 출력");
			System.out.println(Menu.PRINT_ALL+".전체 정보 출력");
			정보 검색/수정/삭제
			
			System.out.println(Menu.EXIT+".종료");
			System.out.println("------------------------------------------------");*/
public interface Menu {
	int INSERT_HIGH = 1;
	int INSERT_UNIV = 2;
	int PRINT_BASIC = 3;
	int PRINT_ALL = 4;
	int SEARCH_INFO=5;
	int MODIFY_INFO=6;
	int DELETE_INFO=7;
	int EXIT = 8;

}
