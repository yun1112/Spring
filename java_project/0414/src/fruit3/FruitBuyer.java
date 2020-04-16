package fruit3;

public class FruitBuyer {
	int myMoney = 5000;
	int numOfApple = 0;

	int buyApple(FruitSeller seller, int money) {
		int num = 0;
		// 사과 판매 개수만큼 구매함
		numOfApple += seller.numOfApple;
		myMoney-=money;//구입한 사과 금액 지출
		
		return myMoney;
	}

}
