package polymorphism;

public class Tv extends Product {

	Tv(int price) {
		super(price);// 상위 클래스 생성자 호출
	}

	@Override
	public String toString() {
		return "Tv";
	}

	void display() {
		System.out.println("Tv를 시청합니다");
	}


}
