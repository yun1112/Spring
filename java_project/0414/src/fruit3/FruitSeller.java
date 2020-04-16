package fruit3;

public class FruitSeller {

	int numOfApple=20;
	int myMoney=0;
	final int price=1000;
	
	int saleApple(int money) {
		int num=numOfApple-money/1000;//판매 후 남은 사과의 개수
		myMoney+=money;//판매 후 벌어들인 금액
		
		return num;
	}
}
