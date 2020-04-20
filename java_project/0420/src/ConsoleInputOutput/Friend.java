package ConsoleInputOutput;

public class Friend {
	String myName;

	Friend(String name) {
		myName = name;
	}
	// 오버라이딩은 반드시 상속관계에 있어야만 사용 가능
	// 메서드의 선언부가 원본 메서드의 선언부와 동일해야 함
	// 오버라이딩(내용만 바꿈)

	public String toString() { // Object 클래스의 toString() 메서드를 재구성함(오버라이딩)
		return "제 이름은 " + this.myName + "입니다";
	}

	public static void main(String[] args) {
		Friend f1 = new Friend("손흥민");
		Friend f2 = new Friend("박지성");

		System.out.println(f1.toString());// Object 클래스 자동상속, 해시코드 반환
		System.out.println(f1);// 참조변수만 출력해도 toString()호출했을 때와 동일한 결과 반환
		System.out.println(f2.toString());
		System.out.println(f2);

		System.out.println(f1.myName);
		System.out.println(f2.myName);
	}

	/*
	 * @Override public String toString() { return "Friend [myName=" + myName + "]";
	 * }
	 */
}
