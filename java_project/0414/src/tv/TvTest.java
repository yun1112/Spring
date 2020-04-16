package tv;

public class TvTest {

	public static void main(String[] args) {
		//Tv인스턴스를 참조하기 위한 변수 t 선언하고 Tv인스턴스 생성
		Tv t=new Tv();
		t.channel=7;//Tv인스턴스의 멤버변수 channel의 값을 설정
		t.channelDown();//채널 낮춤
		System.out.println("현재 채널은 "+t.channel+"입니다");
	}

}
