package inheritance2;

public class Car {
	String color;
	int door;

	void drive() {
		System.out.println("운전");
	}

	void stop() {
		System.out.println("멈춤");
	}
}

class FireEngine extends Car {
	void water() {
		System.out.println("물 뿌리기");
	}
}

class Ambulance extends Car {
	void siren() {
		System.out.println("~~~~~");
	}

	public static void main(String[] args) {
		Car car = null;
		FireEngine fe1 = new FireEngine();
		FireEngine fe2 = null;
		Ambulance am = null;

		fe1.water();
		car = fe1;// 자동 형변환 발생
//		car.water();

		fe2 = (FireEngine) car;// 강제 형 변환

		if (car instanceof Ambulance) {//형 변환 가능 여부 확인
			am = (Ambulance) car;
			am.siren();
		}
	}
}
