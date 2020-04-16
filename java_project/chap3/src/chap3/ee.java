package chap3;

public class ee {

	public static void main(String[] args) {
		int a = (((25 + 5) + (36 / 4)) - 72) * 5, b = (((25 * 5) + (36 - 4)) - 71) / 4, c = (128 / 4) * 2;
		boolean check = (a > b) && (b > c);
		if (check)
			System.out.println("true");
		else
			System.out.println("false");
	}

}
