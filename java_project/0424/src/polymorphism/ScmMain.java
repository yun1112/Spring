package polymorphism;

public class ScmMain {
	public static void main(String[] args) {
		// 상속관계에서 다형성
		// 상위클래스 타입의 참조 변수=하위클래스의 인스턴스
		Product p = new Tv(100);
//		System.out.println(p1);//toString() 오버라이딩 후

		// 고유한 속성 사용하기 위해서는 필수
		Tv tv = new Tv(10);
		Computer com = new Computer(20);
		Audio aud = new Audio(30);

//		int sum = tv.price + com.price + aud.price;

		Product p1 = tv;// 하위클래스의 타입이 상위클래스 타입으로 형변환(자동 형변환)
		Product p2 = com;
		Product p3 = aud;

		// 상위클래스 타입의 배열 생성
		Product[] products = new Product[3];
		products[0] = new Tv(100);
		products[1] = new Computer(200);
		products[2] = new Audio(300);
		
		//명시적인 형변환: 상위타입의 변수에서 하위타입의 변수
		
		//상위타입으로 형변환해야 안에 있는 메서드 사용 가능
		
		if(products[0] instanceof Computer){
//			((Computer)products[0].programming())
		}
		//형변환 하기 전에 형변환이 가능한 타입인지 확인 해야 함
		//instanceof 연산자: 참조변수가 참조하는 인스턴스를 특정 클래스 타입으로 형변환이 가능한지 여부를 확인
		// p1 instanceof Computer==>true/false

		
		//전달하는 배열에 컴퓨터가 있다면 프로그래밍 하겠다
		for (int i = 0; i < products.length; i++) {
			
			if(products[i] instanceof Tv) {
				((Tv)products[i]).display();// display() 메서드 메모리에 있지만 참조변수에 맞는 멤버들만 씀(다형성)
			}
		}
		
		int sumOfPrice=0;
		int sumOfPoint=0;
		
		System.out.println("---------------------------------------------------");
		for (int i = 0; i < products.length; i++) {
			System.out.println(products[i]);
			sumOfPrice+=products[i].price;
			sumOfPoint+=products[i].bonusPoint;
			System.out.println("가격:"+products[i].price);
			System.out.println("포인트:"+products[i].bonusPoint);
			System.out.println("---------------------------------------------------");
		}
		System.out.println("가격 합계:"+sumOfPrice);
		System.out.println("포인트 합계:"+sumOfPoint);
		System.out.println("---------------------------------------------------");
		
		// 구매자가 제품을 구매하는 시뮬레이션
		// 구매자 생성
		Buyer buyer = new Buyer();

		// 제품 생성
		Tv product1 = new Tv(300);
		Computer product2 = new Computer(500);
		Audio product3 = new Audio(300);

		// Tv 구매
		buyer.buy(product1);
		// Computer 구매
		buyer.buy(product2);
		// Audio 구매
		buyer.buy(product3);
		System.out.println("현재 보유금액:" + buyer.money);
		System.out.println("현재 포인트:" + buyer.bonusPoint);
		
		buyer.summary();

	}
}
