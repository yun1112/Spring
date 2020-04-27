package abstract_and_interface;

/*
 친구의 정보를 저장하기 위한 클래스
 상속을 목적으로 기본 클래스로 정의
 기본 속성과 기능을 구성
 */
public abstract class Friend {
	String name;// 친구의 이름
	String phoneNumber;// 친구의 전화번호
	String addr;// 친구의 주소

	Friend(String name, String phoneNumber, String addr) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.addr = addr;
	}

	abstract void showData();

	// 상속의 목적으로 오버라이딩한 메서드
	// 기본 데이터와 하이클래스의 데이터를 출력하도록 오버라이딩 한다
//	void showData() {
//		
//	}
}
