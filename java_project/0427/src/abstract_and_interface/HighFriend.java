package abstract_and_interface;

public class HighFriend extends Friend {
	String work;// 친구의 직업

	HighFriend(String name, String phoneNumber, String addr, String work) {
		super(name, phoneNumber, addr);
		this.work = work;
		
	}

	@Override
	void showData() {
		System.out.println("직업:"+this.work);
	}
}
