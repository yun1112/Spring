package inheritancePrac;

public class carMain {

	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;

		fe.water();
		car = fe;// 하위클래스를 상위클래스 타입으로 형변환(자동 형변환)
//		car.water();//메서드 사용 범위가 줄어듦->하위 클래스 메서드 사용 불가

		fe2 = (FireEngine) car;//상위클래스 객체를 하위클래스 객체 타입으로 형변환(강제 형변환)
		fe.water();
		//메서드 사용 범위가 더 넓기 때문에 캐스팅 연산자 생략 불가
		//형 변환 후 하위클래스 내부에 존재하는 메서드 사용 가능
	}

}
