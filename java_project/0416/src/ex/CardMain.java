package ex;

public class CardMain {

	public static void main(String[] args) {
		Card c1=new Card();//카드 13*4=52장 생성
		Card []c=new Card[52];
	
		String k[]= {"Heart","Clover","Spade","Diamond"};//카드 종류 4가지
		int n[]= {1,2,3,4,5,6,7,8,9,10,11,12,13};//카드 숫자
		
		for (int i = 0; i < 52; i++) {
			c[i]=new Card();
			c[i].kind=k[i%4];//각각의 모양 번갈아가면서 넣음
			c[i].number=n[i%13];//각각의 숫자 번갈아가면서 넣음
			
			System.out.println(c[i].kind+" "+c[i].number);
		}
		
//		for (int i = 0; i < 4; i++) {//카드 종류  spade,heart,clover,diamond
//				c[i+i*13].kind= kind[i];
//			for (int j = 0; j < 13; j++) {//카드 숫자 1~13
//				c[i].number=j+1;
//			}
//		}
	}

}
