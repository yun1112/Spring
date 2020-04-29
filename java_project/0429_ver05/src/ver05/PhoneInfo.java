package ver05;
/*

 * 작성 일자:20/04/29
 *  수정 내용: interface 구현으로 메서드 오버라이딩 생략
 *  PhoneInfo클래스->추상클래스
 * 추상클래스, 상속관계로 구조 변경
 * */
public abstract class PhoneInfo  implements Info{//추상클래스화->PhoneInfo형 인스턴스 생성 막음
	private String name;
	private String phoneNumber;
	private String addr;
	private String email;
//오버라이딩 할 때 더 넓은 범위는 가능하지만 좁은 범위는 불가능
	PhoneInfo(String name, String phoneNumber, String addr, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.addr = addr;
		this.email = email;
	}

	void showBasicInfo() {
		System.out.println("이름:" + this.name);
		System.out.println("전화번호:" + this.phoneNumber);
		System.out.println("주소:" + this.addr);
		System.out.println("메일:" + this.email);
	}

//	void showAllInfo() {
//		showBasicInfo();
//	}

	boolean checkName(String name) {
		boolean check = false;
		if (name.equals(this.name))
			check = true;
		return check;
	}
}