package ex;

public class CardMain2 {
	
	public static void main(String[] args) {
//		Card c1=new Card();
//		c1.kind="Heart";
//		c1.number=7;
		
		Card c1=new Card("Heart",7);
		
		Card c2=new Card();
		c2.kind="Spade";
		c2.number=4;
		
		System.out.println(
				"첫번째 카드는 " + c1.kind + "이고, " + c1.number + "입니다. 카드의 높이는 " + c1.height + "이고, 폭은 " + c1.width + "입니다");
		System.out.println(
				"첫번째 카드는 " + c2.kind + "이고, " + c2.number + "입니다. 카드의 높이는 " + c2.height + "이고, 폭은 " + c2.width + "입니다");

		System.out.println("카드의 사이즈를 변경합니다");

		Card.height = 125;// 스태틱 변수값 변경
		Card.width = 50;
		System.out.println(
				"첫번째 카드는 " + c1.kind + "이고, " + c1.number + "입니다. 카드의 높이는 " + c1.height + "이고, 폭은 " + c1.width + "입니다");
		System.out.println(
				"첫번째 카드는 " + c2.kind + "이고, " + c2.number + "입니다. 카드의 높이는 " + c2.height + "이고, 폭은 " + c2.width + "입니다");

	}

}


