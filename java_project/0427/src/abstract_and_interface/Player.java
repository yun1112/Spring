package abstract_and_interface;

//class 앞에 abstract 키워드가 있는 경우 본 클래스는 추상클래스임을 의미한다
//추상클래스는 미완성된 클래스를 의미한다
//클래스의 멤버 중 추상 메서드를 하나라도 포함하고 있는 경우를 추상클래스라고 한다
//추상메서드란, 미완성된 메서드를 의미한다
public abstract class Player {
	int currentPosition;

	Player(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	abstract void play(int position);
	abstract void stop();
	void play() {
		play(currentPosition);//아직 완성되지 않은 추상메서드를 호출함(새로운 클래스에서 오버라이딩해서 추상메서드를 구현한 후 사용 가능)
	}
	
}
