package fruit;
/*
작성자: 원윤경
수정일:2020.04.17
수정내용: 생성자를 통한 변수 초기화, 현재 데이터 출력 메서드 생성(showResult())

*/

public class FruitSeller {
	// 속성=>변수로 표현
	// 사과의 개수
	// 수입
	// 사과의 가격

	// 수정: 변수의 명시적 초기화 변경(생략)
	int numOfApple;// 사과의 개수,멤버변수,인스턴스 변수
	int myMoney;// 수입
	final int APPLE_PRICE;// 사과의 가격

	// 상수 초기화 안하면 오류남->생성자 만들면 됨
	// 생성자
	FruitSeller() {// default생성자 아님, 내용이 있는 생성자
//		numOfApple = 20;
//		myMoney = 0;
//		APPLE_PRICE = 1000;// 상수를 생성자 내부에서 초기화 해야함
		// 생성자로 초기화 되지 않으면 기본값으로 설정

		this(20, 0, 1000);
	}

//
//	FruitSeller(int numOfApple, int myMoney, int APPLE_PRICE) {
//		this.numOfApple=numOfApple; //파란색:인스턴스 변수/ 갈색: 지역변수
//		this.myMoney=myMoney;
//		this.APPLE_PRICE=APPLE_PRICE;
//	}
	FruitSeller(int numOfApple, int myMoney, int aPPLE_PRICE) {// public 빼도 상관없음
		this.numOfApple = numOfApple;
		this.myMoney = myMoney;
		APPLE_PRICE = aPPLE_PRICE;
	}

	FruitSeller(int p) {
		this(20, 0, p);// 한 변수만 받아서 초기화함
	}

	// 호출하는 쪽은 인자가 정수형인 것만 전달받기 때문에 사용 불가
//	FruitSeller(int n){
//		this(n,0,1000);//한 변수만 받아서 초기화함
//	}

//	int numOfApple = 20;// 사과의 개수,멤버변수,인스턴스 변수
//	int myMoney = 0;// 수입
//	final int price = 1000;// 사과의 가격
//	

	// 판매기능:메서드
//	1.돈을 받는다->매개변수 int money
//	2.받은 돈의 사과의 개수를 구한다
//	3.나의 사과 개수에서 반환하는 사과의 개수를 뺀다
//	4.받은 금액은 나의 수입으로 더해준다
//	5.사과의 개수를 반환한다
	int saleApple(int money) {
		int num = money / APPLE_PRICE;
		numOfApple -= num;
		myMoney += money;
		return num;
	}

	void showResult() {
		System.out.println("현재 보유 금액은 " + myMoney + "이고, 현재 보유한 사과의 개수는 " + numOfApple + "개 입니다");
	}

}
