package example;

public class ex13 {

	public static void main(String[] args) {
		int result = 0;
		for (int i = 2; i < 10; i++) {
			if (i % 2 == 0) {
				System.out.println(i + "단");
				for (int j = 2; j < 10; j++) {
					result = i * j;

					System.out.println(i + "x" + j + "=" + result);
				}
			}
		}
	}
}
