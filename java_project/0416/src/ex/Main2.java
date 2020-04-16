package ex;

public class Main2 {

	public static void main(String[] args) {
		howMany h1=new howMany();//어린이 1 객체
		howMany h2=new howMany();//어린이 2 객체
		
		int leftover1,leftover2;//어린이의 보유자산
		
		h1.setHowmany(15);//어린이 1 보유자산 15
		h2.setHowmany(9);//어린이2 보유자산 9;
		
//		System.out.println(h1.getHowmany());
//		System.out.println(h2.getHowmany());
//		
//		System.out.println("h1:"+h1.getHowmany());
//		System.out.println("h2:"+h2.getHowmany());
		h1.leftover(h2,2);//15+2-7=10
		h2.leftover(h1,7);//9-2+7=14
//		leftover1=h1.leftover(h1.getHowmany(), true);
//		leftover2=h2.leftover(h2.getHowmany(), true);
//		
		leftover1=h1.getHowmany();
		leftover2=h2.getHowmany();
		
		System.out.println(leftover1);
		System.out.println(leftover2);
	}

}
