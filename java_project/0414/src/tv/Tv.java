package tv;

public class Tv {
	String color;
	boolean power;//전원 상태
	int channel;
	
	
	//메서드
	//TV를 켜거나 끄는 기능
	void power() {
		power=!power;//전원이 꺼져있으면 켜고, 켜져있으면 끔
	}
	
	//TV의 채널을 높이는 기능
	void channelUp() {
		++channel;
	}
	
	//TV의 채널을 낮추는 기능
	void channelDown() {
		--channel;
	}
}
