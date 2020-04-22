package ver03;

import java.util.Scanner;

/*
 Project : ver 0.30

배열을 이용해서 프로그램 사용자가 입력하는 정보가 최대 100개까지 유지되도록 프로그램을 변경. 

아래기능 삽입

저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제

데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.

작성자: 원윤경
작성 일자: 2020/04/22
 */
public class PhoneBookMain {

	public static void main(String[] args) {
		PhoneBookManager manager = new PhoneBookManager();
//		PhoneInfor info = null;
		Scanner sc = new Scanner(System.in);
//		Menu menu = new Menu();
		while (true) {
			Menu.showMenu();//public static으로 선언했기 때문에 여기서 메소드 바로 사용 가능

			int selectNum = sc.nextInt();

			sc.nextLine();

			switch (selectNum) {
			case 1:
//				PhoneInfor info = manager.createInstance();
//			//사용자의 입력데이터를 인스턴스 생성
//			//정보를 배열에 저장
				manager.addInfor();
				break;
			case 2:
//			//이름으로 검색
				manager.searchInfor();
				break;
			case 3:
//			//이름으로 검색 후 삭제
				manager.deleteInfor();
				break;
			case 4:
//			//전체 리스트 출력
				manager.showAllData();
				break;
			case 5:
//				return;
				System.out.println("프로그램이 종료되었습니다");
				System.exit(0);
			}

//			info = manager.createInstance();
//			manager.addInfor(info);
//			manager.showAllData();
//			manager.searchInfor();
//			manager.deleteInfor();
//			manager.showAllData();

		}
	}
}
