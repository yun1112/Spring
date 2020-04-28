package inheritance;

/*
수정 일자: 20/04/28
싱글톤 처리
1. 생성자에 접근제어 지시자: private->인스턴스 생성 금지
2. 공동으로 사용할 인스턴스 생성: static private(참조값 외부에서 변경 금지)
3. 참조변수 반환 메서드: static public
*/
import java.util.Scanner;

public class FriendInfoHandler {
	// Friend타입의 정보를 저장할 배열을 가진다
	// 친구의 정보를 저장하는 기능
	// 친구 정보의 기본 정보 출력
	// 친구정보 상세 정보 출력
	// Friend(String name, String phoneNumber,String addr){

	static private FriendInfoHandler handler = new FriendInfoHandler(100);// 2. 공동으로 사용할 인스턴스 생성

	// 3. 참조변수 반환 메서드
	static public FriendInfoHandler getinstance() {
		return handler;
	}

	private Friend[] myFriends;// Friend타입 배열 선언
	private int numOfFriends;// 저장된 친구의 정보 개수
	Scanner sc = new Scanner(System.in);

	// 초기화: 저장 공간(사이즈)의 크기를 받아서 배열 생성
	private FriendInfoHandler(int num) {// 1. 생성자에 접근 제어 지시자 private 지정
		myFriends = new Friend[num];
		numOfFriends = 0;
	}

	// 친구 정보를 저장하는 기능
	// 1.배열에 저장하는 기능
	void addFreindInfo(Friend f) {
		myFriends[numOfFriends++] = f;
	}

	// 2. 사용자에게 데이터를 받아서 사용자 요청에 맞는 인스턴스를 생성
	// HighFriend//UnivFreind

	// throws로 메서드 호출한 쪽에 에러 처리 넘김
	void addFriend(int choice) {
		// 입력하지 않았을 때 재입력을 위한 예외처리 해야 함
		// String IsEmpty() or str.length로 입력 여부 확인

		// 객체가 비어있는지 확인하는 방법
		// 1. isEmpty() 문자열 길이가 0이면 empty string
		// 2.length() isEmpty()의 경우와 같음
		// 3. ==null

		// 기본정보 받기

		System.out.println("이름을 입력해주세요");
		sc.nextLine();// 버퍼에 저장되어있는 엔터 받음
		String name = sc.nextLine();
		System.out.println("전화번호를 입력해주세요");
		String phoneNumber = sc.nextLine();
		System.out.println("주소를 입력해주세요");
		String addr = sc.nextLine();

		try {
			if (name.length()==0 || phoneNumber.length()==0 || addr.length()==0) {
				Exception e = new Exception("에러 발생");
				throw e;
			}

		} catch (Exception e) {
			System.out.println("정보를 입력해 주세요");
		}

		Friend friend = null;
		// 1일 때 정보 받기
		// HighFriend 인스턴스 생성
		if (choice == 1) {
			System.out.println("직업을 입력해주세요");
			String work = sc.nextLine();
			
			try {
				if(work.isEmpty()) {
					Exception e=new Exception("에러 발생");
				}
			}catch(Exception e) {
				System.out.println("정보를 입력해 주세요");
			}
			
			friend = new HighFriend(name, phoneNumber, addr, work);
			
		}
		// 2일 때 정보 받기
		// UnivFriend 인스턴스 생성
		else {
			System.out.println("전공을 입력해주세요");
			String major = sc.nextLine();
			System.out.println("학년을 숫자로 입력해주세요");
			String grade = sc.nextLine();// 정수형 변수로 만들 경우 버퍼문제가 생길 수 있으므로 문자열 타입으로 변수 생성
//			Integer.parseInt(grade);
			
			try {
				if(major.isEmpty() || grade.isEmpty()) {
					Exception e=new Exception();
					throw e;
				}
			}catch(Exception  e) {
				System.out.println("정보를 입력해 주세요");
			}
			
			friend = new UnivFriend(name, phoneNumber, addr, major, Integer.parseInt(grade));
		}

		// addFriendInfo 호출
		addFreindInfo(friend);

	}

	// 친구정보의 기본 정보 출력 기능
	void showAllSimpleData() {
		System.out.println("친구의 기본 정보를 출력합니다");
		for (int i = 0; i < numOfFriends; i++) {
			myFriends[i].showBasicInfo();
			System.out.println("---------------------------------------------------");
		}
	}

	void showAllData() {
		System.out.println("친구의 모든 정보를 출력합니다");
		for (int i = 0; i < numOfFriends; i++) {
			myFriends[i].showData();
		}
	}
	// 친구정보 삭제 정보 출력 기능
}
