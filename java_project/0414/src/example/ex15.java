package example;

import java.util.Scanner;

public class ex15 {

	public static void main(String[] args) {
		int n = 0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		if (n == 1)
			System.out.println("현재 인원은 1명입니다");

		else if (n == 2)
			System.out.println("현재 인원은 2명입니다");

		else if (n == 3)
			System.out.println("현재 인원은 3명입니다");

		else if (n > 3)
			System.out.println("현재 많은 사람들이 있습니다");

	}
}
