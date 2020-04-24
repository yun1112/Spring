package inheritance;

public class OverridingTest {

	public static void main(String[] args) {
		// 다형성: 상위클래스 타입의 참조변수에 하위클래스의 인스턴스를 참조
		Speaker sp = new BaseSpeaker();
		//참조변수 sp는 BaseSpeaker인스턴스의 멤버 중 Speaker가 가지던 멤버만 사용한다
		
		sp.showCurrentState();
//		sp.setBaseRate(100);

		System.out.println("--------------------------------------------------");

		BaseSpeaker bSpeaker = new BaseSpeaker();
		bSpeaker.setVolume(10);
		bSpeaker.setBaseRate(20);
		bSpeaker.showCurrentState();
		System.out.println(bSpeaker);
	}

}
