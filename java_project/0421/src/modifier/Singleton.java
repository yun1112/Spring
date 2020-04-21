package modifier;

public class Singleton {//싱글톤 패턴: 기능만 가짐
	// 1. 생성자의 접근제어지시자: private->인스턴스 생성 불가
	private Singleton() {
	}

	// 2. 공유할 객체를 생성
	private static Singleton s = new Singleton();// static-외부에서 접근해서 수정 가능

	// 3. 참조값을 반환하는 메서드를 생성
	public static Singleton getInstance() {
		return s;
	}
	
	public void print() {
		System.out.println("Singleton Pattern");
	}
}
