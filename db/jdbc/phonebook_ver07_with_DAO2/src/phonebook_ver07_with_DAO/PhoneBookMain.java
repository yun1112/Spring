package phonebook_ver07_with_DAO;
//코드 생성 일자: 06/02

//일단 대학정보로만 만듦->대학/회사/동호회 정보 모두 추가

import java.util.Scanner;

public class PhoneBookMain {

	static Scanner sc = new Scanner(System.in);// 외부 클래스에서 가져다 쓸 수 있도록 static 선언

	public static void main(String[] args) throws ClassNotFoundException {
			Class.forName("oracle.jdbc.driver.OracleDriver");//데이터베이스 드라이버 로드
			System.out.println("데이터베이스 드라이버 로드 완료");
		
			PhoneBookManager phoneManager=new PhoneBookManager();
			
			while(true) {
				System.out.println("선택");
				System.out.println("1.대학교");//일단 대학교만 코드 작성
				System.out.println("2.회사");
				System.out.println("3.동호회");
				
				int select=sc.nextInt();
				
				switch(select) {
				case 1:
					phoneManager.PhoneBookManager();
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					System.out.println("잘못된 입력값입니다.\n다시 입력해 주세요.");
					break;
				}
			}
		
		
	}

}
