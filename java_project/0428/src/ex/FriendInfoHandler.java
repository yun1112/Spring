package ex;

import java.util.Scanner;

//싱글톤 패턴 구현void showData();
//친구 정보(고교/대학) 저장/기본 출력/상세 출력
//+검색/수정/삭제
public class FriendInfoHandler {
	static private FriendInfoHandler handler = new FriendInfoHandler(100);// static private, 공동으로 사용할 수 있는 인스턴스 생성

	static public FriendInfoHandler getInstance() {// 참조변수 반환 메서드
		return handler;
	}

	private Friend[] myFriends;
	private int numOfFriends;
	Scanner sc = new Scanner(System.in);

	private FriendInfoHandler(int num) {// private 생성자
		myFriends = new Friend[num];
		numOfFriends = 0;
	}

	// 친구 정보 검색 메서드
	void searchFriends() {
		String name = sc.nextLine();
		int index = searchIndex();

		if (index < 0)
			System.out.println("찾으시는 정보가 없습니다");
		else
			myFriends[index].showData();

//		for (int i = 0; i < numOfFriends; i++) {
//			myFriends[i].showData();
//		}
	}

	int searchIndex() {
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();

		int search = -1;// 검색 결과 없을 경우

		for (int i = 0; i < numOfFriends; i++) {
			if (myFriends[i].name.equals(name)) {
				search = i;
				return search;
			}
		}
		return search;
	}

	// 친구 정보 수정 메서드
	void modifyFriends() {
		int index = searchIndex();
		int type=0;
		Friend f = null;
		if (index < 0) {
			System.out.println("찾으시는 정보가 없습니다");
			System.out.println("정보를 다시 입력해주세요");
			System.out.println("--------------------------------------------------------------------------");
		} else {
			System.out.println("--------------------------------------------------------------------------");
			for (int i = 0; i < numOfFriends; i++) {
				if(myFriends[i].name.equals(myFriends[index])){
					if(myFriends[i] instanceof HighFriend) {
						type=1;
					}else if(myFriends[i] instanceof UnivFriend) {
						type=2;
					}
				}
			}
			
			
			switch (type) {
			case 1:
				// f = new HighFriend(name, phoneNumber, addr, identification, classNum);
				// 이름 제외하고 모든 정보 다시 받아야 됨
				System.out.println("전화번호:");
				String phoneNumber = sc.nextLine();
				System.out.println("주소:");
				String addr = sc.nextLine();
				System.out.println("학생증 번호:");
				String identification = sc.nextLine();
				System.out.println("반:");
				String classNum = sc.nextLine();
				f = new HighFriend(myFriends[index].name, phoneNumber, addr, identification, classNum);
				break;
			case 2:
				// f = new UnivFriend(name, phoneNumber, addr, major, grade);
				System.out.println("전화번호:");
				String phoneNumber1 = sc.nextLine();
				System.out.println("주소:");
				String add1r = sc.nextLine();
				System.out.println("전공:");
				String major = sc.nextLine();
				System.out.println("학점:");
				String grade = sc.nextLine();
				f = new UnivFriend(myFriends[index].name, phoneNumber1, add1r, major, grade);
				break;
			default:
				break;
			}
		}
	}

	// 친구 정보 삭제 메서드
	void deleteFriends() {
		int index = searchIndex();
		if (index < 0) {
			System.out.println("찾으시는 정보가 없습니다");
			System.out.println("--------------------------------------------------------------------------");
		} else {
			for (int i = index; i < numOfFriends - 1; i++) {
				myFriends[i] = myFriends[i + 1];
			}
			numOfFriends--;
		}
	}

	// 친구 정보 저장 메서드
	void SaveFreinds(int type) {
		Friend f = null;// 인스턴스 초기화

//		int type = Integer.parseInt(sc.nextLine());
		System.out.println("이름:");
		String name = sc.nextLine();
		System.out.println("전화번호:");
		String phoneNumber = sc.nextLine();
		System.out.println("주소");
		String addr = sc.nextLine();

		switch (type) {
		case 1:
			System.out.println("학생증 번호:");
			String identification = sc.nextLine();
			System.out.println("반:");
			String classNum = sc.nextLine();

			f = new HighFriend(name, phoneNumber, addr, identification, classNum);
			break;
		case 2:
			System.out.println("전공:");
			String major = sc.nextLine();
			System.out.println("학년");
			String grade = sc.nextLine();
			f = new UnivFriend(name, phoneNumber, addr, major, grade);
			break;
		default:
			System.out.println("잘못 입력하셨습니다");
			System.out.println("--------------------------------------------------------------------------");
			break;

		}
		addFriends(f);
	}

	void addFriends(Friend f) {
		myFriends[numOfFriends++] = f;
	}

	// 기본 출력 메서드(고교/대학 별 정보 출력)
	void printBasic() {
		for (int i = 0; i < numOfFriends; i++) {
			if (myFriends[i] instanceof HighFriend) {
				System.out.println(myFriends[i] + "정보 출력");
				myFriends[i].showData();
			} else if (myFriends[i] instanceof UnivFriend) {
				System.out.println(myFriends[i] + "정보 출력");// toString() 메서드 오버라이딩 결과 출력
				myFriends[i].showData();
			}
			System.out.println("--------------------------------------------------------------------------");
		}
	}

	// 상세 출력 메서드(입력된 모든 정보 출력)
	void printAll() {
		for (int i = 0; i < numOfFriends; i++) {
			myFriends[i].showData();
			System.out.println("--------------------------------------------------------------------------");
		}

	}
}
