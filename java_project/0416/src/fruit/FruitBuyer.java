package fruit;
/*
작성자: 원윤경
수정일:2020.04.17
수정내용: 생성자를 통한 변수 초기화*/

public class FruitBuyer {
//속성:변수
//보유한 나의 돈
//사과의 개수
	
	//변수의 명시적 초기화 변경
	int myMoney;
	int numOfApple ;
//	int myMoney = 10000;
//	int numOfApple = 0;
	
	//생성자
	public FruitBuyer() {
		myMoney=5000;
		numOfApple=0;
	}
	
	public FruitBuyer(int m, int n) {
		myMoney=m;
		numOfApple=n;
	}

//	구매기능:메서드
//	1.셀러 찾기/받기
//	2.지출할 돈 정의
//	3.셀러에게 돈을 주고 판매요청->사과의 개수
//	4.사과의 개수를 받은 사과의 개수만큼 증가시킨다
//	5.지출한 돈은 나의 돈에서 차감한다

	// 참좁변수:
	void buyApple(FruitSeller seller, int money) {
		// 구매한 사과의 개수
		int num = seller.saleApple(money);
		numOfApple += num;
		myMoney -= money;
	}
}
