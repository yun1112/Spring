package modifier;

public class TestMain {

	public static void main(String[] args) {
		
		Singleton s=Singleton.getInstance();//객체 참조변수 가져옴
		s.print();
		
		
		Member member = new Member();
		member.setId("아이디");
		member.setName("이름");
		System.out.println(member.getId());//default 상태로 바꿔야 함
		System.out.println(member.getName());//default 상태로 바꿔야 함
		
//		Singleton.s=null; 발생하면 안됨(Singleton이 static인 경우)
	}

}
