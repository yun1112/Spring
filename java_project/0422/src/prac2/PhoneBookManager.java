package prac2;

//수정해야 할 사항
//하위클래스 인스턴스 생성시 null값 참조했다고 뜸
//type에 입력힌 깂 저장이 안되고 0이라고 뜸
//typeChoice 메서드
//메서드 순서만 바꾸면 됨
//객체 배열에 요소 추가할 때 사용할 메서드 따로 빼기
//addInfor() 메서드 따로 만들기


/*
타입 선택 후 1~5 선택받아서 해당하는 일 수행하도록 코드 수정
/*
 * 다음 두 클래스를 추가로 삽입. 상속 구조가 가능하다면 상속 구조로 구성 해보세요.
PhoneUnivInfor, PhoneCompaanyInfor, 개인적인 클래스 추가
PhoneUnivInfor
이름 name String
전화번호 phoneNumber String
주소 address String
이메일 email String


전공 major String
학년 year String

PhoneCompaanyInfor
이름 name String
전화번호 phoneNumber String
주소 address String

이메일 email String
회사 company String

추가한 클래스
+PhoneUnivInfor, PhoneCompaanyInfor, PhoneAcademyInfor

Ex) PhoneCafeInfor 또는 PhoneFamilyInfor 등을 추가해 보자

작성자: 원윤경
작성 일자:2020/04/24
변경 사항: 클래스 추가, 상속
*/

//새 인스턴스 생성 시에 instanceof 사용하지 않더라도 메서드를 통해서 자동 형변환 할 수 있음(매개변수로 상위클래스 객체 씀)

//상속 후 오버라이딩 이용할 것 
import java.util.Arrays;
import java.util.Scanner;

public class PhoneBookManager {
	PhoneInfor[] pBooks;
	// PhoneUnivInfor, PhoneCompaanyInfor, PhoneAcademyInfor

	// PhoneUnivInfor(String name, String phoneNumber,String major, String year) {
	PhoneUnivInfor pUniv;
	PhoneCompanyInfor pCom;
	PhoneAcademyInfor pAca;
	// 하위 클래스 인스턴스를 배열 pBooks에 담음
	// 하위클래스 배열로 처리할 필요 없음

	// 입력받기 전에 전화번호 입력받을 타입 선택

	private int cnt;
	Scanner sc;
	int type;//static or not/ private or not 결정

	PhoneBookManager() {
		pBooks = new PhoneInfor[100];
//		pUniv=new PhoneUnivInfor[100];
//		pCom=new PhoneCompanyInfor[100];
//		pAca=new PhoneAcademyInfor[100];

		// 새 인스턴스 생성 시에 instanceof 사용할 것

		// 타입 선택 메서드 호출->타입 값 반환
		// 타입 선택 후 객체 생성
//		type = typeChoice();

		// 매개변수 입력받는 메서드 호출

		//타입 선택하는 메서드 따로 빼서 만듦
		
//		switch (type) {
//		case 1:// type=1 대학 선택했을 경우 하위 클래스 PhoneUnivInfor pUniv생성
//			pBooks[cnt] = createInstance();// 상위 클래스 타입 인스턴스 생성
////			pUniv = (PhoneUnivInfor) pBooks[cnt];// 명시적 형변환
//			System.out.println(pBooks[cnt]);//새로 생성한 객체 확인
//			break;
//
//		case 2:// PhoneCompaanyInfor, PhoneAcademyInfor
//			
//			break;
//		case 3:
//			break;
//		}

//	PhoneUnivInfor(String name, String phoneNumber,String major, String year) {
//		pUniv=new PhoneUnivInfor("");
//		pCom=new PhoneCompanyInfor();
//		pAca=new PhoneAcademyInfor();
		// 하위클래스 배열로 처리할 필요 없음

		// 객체 배열을 사용해서 메서드를 통합해서 한 번에 처리하기 위해서
		// 하위클래스를 상위클래스타입으로 형변환

//		pUniv=pBooks;

		cnt = 0;
		sc = new Scanner(System.in);
	}

	// 입력받기 전에 전화번호 입력받을 타입 선택
	// PhoneUnivInfor, PhoneCompaanyInfor, PhoneAcademyInfor
//	int typeChoice() {
//
//
////		type = sc.nextInt();
//
//		return type;
//	}

	/*
	 * // PhoneUnivInfor, PhoneCompaanyInfor, PhoneAcademyInfor 하위 클래스 종류에 따라서 다른
	 * 매개변수 입력받아서 초기화함
	 */

	//타입 정하는 메서드
	
	
	//PhoneInfor[] pBooks;
	//addInfor 메서드 생성
	// instanceof 연산자로 객체 종류 확인함
//	PhoneInfor addInfor(PhoneInfor p) {
		void addInfor(PhoneInfor p) {//오버라이딩과 배열에 인스턴스 추가 목적을 가진 메서드
//		String name=sc.nextLine();
//		String phoneNumber=sc.nextLine();
//		String address=sc.nextLine();
//		String email=sc.nextLine();
		
//		pBooks[cnt++]=new PhoneInfor(name,phoneNumber,address,email);//새로운 인스터스 생성
		pBooks[cnt++]=p;//객체 배열에 새로운 인스턴스 추가
		
//		return pBooks[cnt];
	}
	
	//여기에서 매개변수로 PhoneInfor타입 받아서 자동 형변환
	PhoneInfor createInstance() {
		//타입 전달해서 유형별로 하위클래스의 인스턴스 객체 생성(x)

		// 기본 인자 입력받음
//		sc.next();
		sc.nextLine();//엔터 받아주는 스캐너 필요함
		
		System.out.println("이름을 입력하세요>>");
		String name = sc.nextLine();

		System.out.println("전화번호를 입력하세요>>");
		String phoneNumber = sc.nextLine();

		System.out.println("주소을 입력하세요>>");
		String address = sc.nextLine();

		System.out.println("이메일을 입력하세요>>");
		String email = sc.nextLine();

		// 타입 확인 후 고유 인자 입력받음

		// 공통 매개변수: name, phoneNumber, address, email
		// 고유 매개변수: major, year
		// PhoneUnivInfor(String name, String phoneNumber,String major, String year) {
//		if(pBooks[cnt] instanceof PhoneUnivInfor) {//현재 객체가 PhoneUnivInfor인스턴스 타입일 경우

//		System.out.println("입력한 유형:"+type);//입력한 type 확인
		switch (type) {
		// 선택한 현재 객체가 PhoneUnivInfor인스턴스 타입일 경우
		case 1:
			System.out.println("전공을 입력하세요>>");
			String major = sc.nextLine();

			System.out.println("입학연도를 입력하세요>>");// 입학연도 or 학년
			String year = sc.nextLine();

			 pUniv= new PhoneUnivInfor(name, phoneNumber, address, email, major, year);// 추가
//			 pBooks[cnt]=pUniv;//자동 형변환
			 addInfor(pUniv);//하위클래스 객체를 매개변수로 보내서 자동 형변환 발생
			 
			break;

		// PhoneCompanyInfor(String name, String phoneNumber,String email, String
		// company){
		case 2:
			System.out.println("회사명을 입력하세요");
			String company = sc.nextLine();
			pBooks[cnt] = new PhoneCompanyInfor(name, phoneNumber, address, email, company);// 추가
			break;
		case 3:
			System.out.println("수강생 번호를 입력하세요");
			String id = sc.nextLine();
			pBooks[cnt] = new PhoneAcademyInfor(name, phoneNumber, address, email, id);// 추가
			break;

		}

		// 객체 생성 완료 후 toString메서드 불러와서 어떤 객체 생성했는지 확인하는 메시지 출력
		System.out.println(pBooks[cnt-1] + " 정보를 등록했습니다");
//
//		if (birthday == null || birthday.trim().isEmpty()) {
//			pBooks[cnt] = new PhoneInfor(name, phoneNumber);
//		} else {
//			pBooks[cnt] = new PhoneInfor(name, phoneNumber);
//		}

		//cnt++;

		return pBooks[cnt-1];
	}
	
	void typeChoice() {
		//메서드 순서만 바꾸면 됨
//		Menu.printMenu();
		type=sc.nextInt();//타입 인식 됨
		switch (type) {
		case 1:// type=1 대학 선택했을 경우 하위 클래스 PhoneUnivInfor pUniv생성
			pBooks[cnt] = createInstance();// 상위 클래스 타입 인스턴스 생성
//			pUniv = (PhoneUnivInfor) pBooks[cnt];// 명시적 형변환
//			System.out.println("새로 생성한 객체:"+pBooks[cnt+1]);//새로 생성한 객체 확인->계속 null뜸
//			System.out.println("새로 생성한 객체:"+pBooks[cnt]);//새로 생성한 객체 확인->계속 null뜸
			System.out.println("새로 생성한 객체:"+pBooks[cnt-1]);//새로 생성한 객체 확인->계속 null뜸
			break;

		case 2:// PhoneCompaanyInfor, PhoneAcademyInfor
			
			break;
		case 3:
			break;
		}
		
		System.out.println(pBooks[cnt-1]+"선택했습니다(1단계)");
		Menu.printMenu();
	}

//	void addInstance() {}

	void showAllData() {
		for (int i = 0; i < cnt; i++) {
			pBooks[i].showInfor();
		}
	}

	int searchIndex(String name) {
//		int searchindex = -1;
		int searchindex = -1;
		for (int i = 0; i < cnt; i++) {
			if (pBooks[i].getName().equals(name)) {
				searchindex = i;
			}
		}
		return searchindex;
	}

	void searchInfor() {
		String name = sc.nextLine();
		int searchindex = searchIndex(name);
		if (searchindex < 0) {
			System.out.println("해당 정보가 존재하지 않습니다");
		} else {
			pBooks[searchindex].showInfor();
		}

	}

	void deleteInfor() {
		String name = sc.nextLine();
		int searchindex = searchIndex(name);

		if (searchindex < 0) {
			System.out.println("해당 정보가 존재하지 않습니다");
		} else {

			for (int i = searchindex; i < cnt; i++) {
				pBooks[i] = pBooks[i + 1];
			}
			cnt--;
		}
		System.out.println("삭제를 완료했습니다");
	}
}
