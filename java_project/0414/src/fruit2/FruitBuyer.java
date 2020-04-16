package fruit2;

public class FruitBuyer {
	int numOfApple=20;
	int myMoney=0;
	final int price=1000;
	
	int buyApple(FruitSeller seller,int money) {
		//1.구매자 보유 금액 줄어듦
		//2.구매자 사과 개수 증가함
		myMoney-=money;//보유 금액 감소
		
		numOfApple+=money/price;//사과 개수 증가함
		
		return numOfApple;
	}
}
