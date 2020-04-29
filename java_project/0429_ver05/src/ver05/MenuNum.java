package ver05;

/*	System.out.println("메뉴를 입력해주세요");
	System.out.println("1.친구 정보 입력");
	System.out.println("2.친구 정보 검색");
	System.out.println("3.친구 정보 삭제");
	System.out.println("4.친구 정보 수정");
	System.out.println("5.친구 정보 전체 보기");
	System.out.println("6.프로그램 종료");
	
	1.대학 2.회사 3.동호회
	
	*/

//interface 내의 변수는 무조건 상수
//public static final 자료형 상수(생략 가능)
public interface MenuNum {
	int INSERT = 1, SEARCH = 2, DELETE = 3, EDIT = 4, PRINT_ALL = 5, EXIT = 6;
	int UNIV=1, COMPANY=2,CAFE=3;
	
	char INSERT_CHAR='i';//문자형 변수도 상수로 정의 가능->정수형 변수와 같은 방식으로 문자형 변수로 분기 가능
}

//문자열로 입력 받은 다음에 0번지에 있는 문자만 인식하도록 구현할 수도 있음
