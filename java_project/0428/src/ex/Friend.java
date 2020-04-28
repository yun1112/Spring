package ex;

public abstract class Friend implements Info{//Inteface Info를 implements해서 추상클래스화함
	String name;
	String phoneNumber;
	String addr;

	Friend(String name, String phoneNumber, String addr) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.addr = addr;
	}
	
//	void showData() {
//		System.out.println("이름:"+this.name);
//		System.out.println("전화번호:"+this.phoneNumber);
//		System.out.println("주소:"+this.addr);
//	}
	void showBasicData() {
		System.out.println("이름:"+this.name);
		System.out.println("전화번호:"+this.phoneNumber);
		System.out.println("주소:"+this.addr);
	}

	@Override
	public String toString() {
		return "친구  [이름:" + name + ", 전화번호:" + phoneNumber + ", 주소:" + addr + "]";
	}

}
