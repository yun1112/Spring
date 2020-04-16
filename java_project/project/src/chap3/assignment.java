package chap3;

public class assignment {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < 11; i++) {
			System.out.print("(");
			for (int j = 1; j < i + 1; j++) {
				sum += (j);
				System.out.print(j);
				if (j < i)
					System.out.print("+");

			}
			System.out.print(")");
			if (i < 10)
				System.out.print("+");
		}
		System.out.println("\ntotal: l" + sum);

	}

}
