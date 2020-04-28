package ex;

public class UnivFriend extends Friend {
	String major;
	String grade;

	UnivFriend(String name, String phoneNumber, String addr, String major, String grade) {
		super(name, phoneNumber, addr);
		this.major = major;
		this.grade = grade;
	}

	public void showData() {
		super.showBasicData();
		System.out.println("전공:"+this.major);
		System.out.println("학년"+this.grade);
	}

	@Override
	public String toString() {
		return super.toString()+" 대학 친구[전공:" + major + ", 학년:" + grade + "]";
	}

}
