package ex;

public class HighFriend extends Friend {
	String identification;
	String classNum;

	HighFriend(String name, String phoneNumber, String addr, String identification, String classNum) {
		super(name, phoneNumber, addr);
		this.identification = identification;
		this.classNum = classNum;
	}

	public void showData() {
		super.showBasicData();
		System.out.println("학생증 번호:"+this.identification);
		System.out.println("반:"+this.classNum);
	}

	@Override
	public String toString() {
		
		return super.toString()+" 고교 친구 [학생증 번호:" + identification + ", 반:" + classNum + "]";
	}
	

}
