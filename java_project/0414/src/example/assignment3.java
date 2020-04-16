package chap3;

public class assignment3 {

	public static void main(String[] args) {
		int result = 0;

		for (int x = 0; x < 11; x++) {
			for (int y = 0; y < 11; y++) {
				result = 2 * x + 4 * y;
				if (result == 10)
					System.out.println("x=" + x + ", y=" + y);
			}

		}
	}

}
