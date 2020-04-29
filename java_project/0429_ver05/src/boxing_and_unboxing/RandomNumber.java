package boxing_and_unboxing;

import java.util.Random;

public class RandomNumber {
	public static void main(String[] args) {
		Random rand=new Random(System.currentTimeMillis());//new Random(1) 난수 한번만 발생시킴(게임 만들 때 유용, 같은 스테이지에서 같은 패턴 나오도록 만들 때 유용)
//		Random rand=new Random(System.nanoTime()());
		for (int i = 0; i < 10; i++) {
//			System.out.println(rand.nextBoolean());
			System.out.println(rand.nextInt(45)+1);//0~45
//			System.out.println(rand.nextDouble());
			System.out.println("-----------------------------------------------");
		}
	}
}

//Random rand=new Random(System.nano());
