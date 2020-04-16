package chap3;

public class ex11 {

	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i < 100; i++) {
			if (i % 5 != 0 || i % 7 != 0)
				continue;
			count++;
			System.out.println(i);
		}
		System.out.println("count:" + count);
	}

}
