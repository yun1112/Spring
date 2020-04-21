package membership;

//회원 정보를 저장하기 위한 클래스 생성
public class Member {// 객체에 있는 데이터 확인하기 위해 toString()메서드 오버라이딩함
	String memberId;//회원정보는 고유한 값이므로 공용값에 적용되는 static 쓰면 안됨
	String memberName;
	String memberEmail;

	//생성자
	Member() {

	}

	Member(String memberId, String memberName, String memberEmail) {
		this.memberId=memberId;
		this.memberName=memberName;
		this.memberEmail=memberEmail;
	}
	void showInfo() {
		System.out.println("아이디: "+this.memberId);//this  생략 가능
		System.out.println("이름: "+this.memberName);//this  생략 가능
		System.out.println("메일: "+this.memberEmail);//this  생략 가능
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", memberEmail=" + memberEmail + "]";
	}
	
}
