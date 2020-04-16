package fruit2;

public class FruitSeller {
//	final int APPLE_PRICE=1000;//사과판매가격 상수로 정의
	int numOfApple=20;
	int myMoney=0;
	final int price=1000;
	
	//판매자
	//1.현재 사과 보유 개수 즐어듦
	//2.현재 보유 금액 증가함
	int saleApple(int money) {
		int num;
		numOfApple-=money/1000;//사과 보유 개수 감소
		myMoney+=money;//사과 가격만큼 현재 보유 금액 증가함
		num=numOfApple;
		return num;
	}

}
