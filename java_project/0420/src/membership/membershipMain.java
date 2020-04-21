package membership;

public class membershipMain {

	public static void main(String[] args) {
		//회원 정보 5개를 저장할 수 있는 배열을 생성
		//Member 타입의 인스턴스의 참조값을 저장하는 메모리 공간
		//Member m1,m2,m3,m4,m5
		Member[] members=new Member[5];
		members[0]=new Member("cool","시원한","cool@gmail.com");// Member 타입의 인스턴스 주소
		members[1]=new Member("hot","뜨거운","hot@gmail.com");// Member 타입의 인스턴스 주소
		members[2]=new Member("harsh","가혹한","harsh@gmail.com");// Member 타입의 인스턴스 주소
		members[3]=new Member("invaluable","귀중한","invaluable@gmail.com");// Member 타입의 인스턴스 주소
		members[4]=new Member("diligent","근면한","diligent@gmail.com");// Member 타입의 인스턴스 주소
		
		for (int i = 0; i < members.length; i++) {
			members[i].showInfo();
			System.out.println(members[i]);
			System.out.println(members[i].toString());
		}
		
//		Member member=new Member("cool","시원한","cool@gmail.com");
//		member.showInfo();
		System.out.println("---------------------------------------------------------------------");
		System.out.println(members);//member.toString() 호출
	}

}
