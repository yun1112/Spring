package inheritance;

public class BusinessMan extends Man {

	// 상위 클래스에 default 생성자 없으므로 오류남 -> 생성자 호출해야 함
//	BusinessMan() {
//	}

	// 생성자 호출의 예외
	// 명시적으로 값 전달하는 경우
//	BusinessMan(){
//		super("string");
//	}

	// 조상클래스의 생성자가 있다면 자손클래스의 생성자에서
	// 값을 받아 조상 클래스의 생성자를 호출해서 초기화해준다

	String company;
	String position;

	BusinessMan(String name, String company, String position) {
		super(name);
		this.company = company;
		this.position = position;
	}


	void tellYourInfo() {
//		super.tellYourName();
		tellYourName();
		System.out.println("나의 직장 이름은 "+company+"입니다");
		System.out.println("나의 직급은 "+position+"입니다");
	}
}
