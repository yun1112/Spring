package ex;

public class MemberCall {
	//인스턴스 변수
	int iv = 10;
	
	//클래스 변수, 스태틱 변수
	static int cv=100;
	
	int iv2=cv;
	
//	static int cv2=iv;
	//단 한번만 사용할 경우
	static int cv2=new MemberCall().iv;//인스턴스 생성하고 주소값은 저장 안함
	static void staticMethod() {
		//스태틱 멤버 출력
		System.out.println(cv);
		
		//인스턴스 멤버 출력
//		System.out.println(iv);
		MemberCall c=new MemberCall();//인스턴스 생성
		System.out.println(c.iv);
		
	}
	
	void instancaMethod() {
		//스태틱 멤버 출력
		System.out.println(cv);
		
		//인스턴스 멤버 출력
		System.out.println(iv);
	}
		
	
}
